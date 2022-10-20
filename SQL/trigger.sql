
CREATE TABLE IF NOT EXISTS agencia (
    cod_agencia SERIAL PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    endereco VARCHAR(120) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

INSERT INTO agencia (nome, endereco, telefone) VALUES
('CENTRO - ITUMBIARA', 'RUA PRINCIPAL, 1', '64999999999');

INSERT INTO agencia (nome, endereco, telefone) VALUES
('RODOVIARIA - ITUMBIARA', 'RUA SECUNDÁRIA, 2', '64999999991');

SELECT * FROM agencia ORDER BY cod_agencia;

CREATE TABLE IF NOT EXISTS funcionario (
    cod_funcionario SERIAL PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    cod_agencia INTEGER REFERENCES agencia
);

INSERT INTO funcionario (nome, cod_agencia) VALUES 
('FUNCIONARIO 1', 1),
('FUNCIONARIO 2', 1);

SELECT * FROM funcionario;

ALTER TABLE agencia ADD COLUMN gerente INTEGER REFERENCES funcionario;

UPDATE agencia
SET gerente = 1
WHERE cod_agencia = 1;

CREATE TABLE IF NOT EXISTS cliente (
    cod_cli SERIAL PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    sobrenome VARCHAR(120) NOT NULL,
    endereco VARCHAR(120) NOT NULL,
    genero CHAR(1) NOT NULL,
    CHECK (genero IN ('M', 'F'))
);

INSERT INTO cliente (nome, sobrenome, endereco, genero) VALUES
('PATINHAS', 'MC MONEY', 'CASA 1', 'M'),
('RIQUINHO', 'RICO', 'FORT KNOX', 'M'),
('LUIZA', 'TRAJANO', 'MAGALU', 'F');

SELECT * FROM cliente;

CREATE TABLE IF NOT EXISTS conta (
    cod_conta SERIAL PRIMARY KEY,
    cod_agencia INTEGER NOT NULL REFERENCES agencia,
    cod_cli INTEGER NOT NULL REFERENCES cliente,
    saldo NUMERIC(15,2) NOT NULL, 
    limite NUMERIC(7,2) NOT NULL DEFAULT (100.00)
);

INSERT INTO conta (cod_agencia, cod_cli, saldo) VALUES
(1, 1, 100.00),
(1, 2, 200.00),
(1, 3, 400.00);

SELECT * FROM conta ORDER BY cod_conta;

UPDATE conta
SET limite = 200.00
WHERE cod_conta = 3;

CREATE TABLE IF NOT EXISTS saque (
    cod_saque SERIAL PRIMARY KEY,
    dt_saque DATE NOT NULL DEFAULT (CURRENT_DATE),
    cod_conta INTEGER NOT NULL REFERENCES conta,
    valor_saque NUMERIC(15,2) NOT NULL,
	CHECK (valor_saque > 0)
);

SELECT * FROM saque;

CREATE TABLE IF NOT EXISTS deposito (
    cod_deposito SERIAL PRIMARY KEY,
    dt_deposito DATE NOT NULL DEFAULT (CURRENT_DATE),
    cod_conta INTEGER NOT NULL REFERENCES conta,
    valor_deposito NUMERIC(15,2) NOT NULL,
	CHECK (valor_deposito > 0)
);

SELECT * FROM deposito;

CREATE TABLE IF NOT EXISTS transferencia (
    cod_transf SERIAL PRIMARY KEY,
    dt_transf DATE NOT NULL DEFAULT (CURRENT_DATE),
    cod_conta_deb INTEGER NOT NULL REFERENCES conta,
    cod_conta_cred INTEGER NOT NULL REFERENCES conta,
    valor_transf NUMERIC(15,2) NOT NULL,
	CHECK (valor_transf > 0)
);

SELECT * FROM transferencia;



----------------- Controle de limite no cadastro --------------------

--função que será chamada pela trigger
CREATE OR REPLACE FUNCTION fc_limite_padrao() RETURNS TRIGGER AS
$$
BEGIN
    --define que o limite será R$ 100.00
    NEW.limite = 100.00;
    --Continua o insert
    RETURN NEW;

END;
$$
LANGUAGE plpgsql;

--estrutura da trigger
CREATE TRIGGER tr_limite_padrao
BEFORE INSERT ON conta
FOR EACH ROW EXECUTE PROCEDURE fc_limite_padrao();

----------------- Verifica se existe saldo na conta antes do saque --------------------

CREATE OR REPLACE FUNCTION fc_verifica_saque() RETURNS TRIGGER AS
$$
BEGIN
    IF ( NEW.valor_saque > ( SELECT (saldo + limite) FROM conta WHERE cod_conta = NEW.cod_conta)) THEN 
        RAISE EXCEPTION 'NÃO EXISTE SALDO SUFICIENTE PARA O SAQUE.';
    ELSE 
        UPDATE conta SET saldo = saldo - NEW.valor_saque WHERE cod_conta = NEW.cod_conta;
        RAISE NOTICE 'SAQUE EFETUADO!';
        RETURN NEW;
    END IF;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_verifica_saque 
BEFORE INSERT ON saque
FOR EACH ROW EXECUTE PROCEDURE fc_verifica_saque();

--simular saque maior que limite + saldo

INSERT INTO saque (cod_conta, valor_saque) VALUES
(1, 300.00);

SELECT * FROM conta WHERE cod_conta = 1;
SELECT * FROM saque;

--simular saque menor que limite + saldo

INSERT INTO saque (cod_conta, valor_saque) VALUES
(1, 30.00);

SELECT * FROM conta WHERE cod_conta = 1;
SELECT * FROM saque;

------------ Acrescentar valor depositado na conta ------------

CREATE OR REPLACE FUNCTION fc_verifica_deposito() RETURNS TRIGGER AS
$$
BEGIN

    UPDATE conta 
        SET saldo = saldo + NEW.valor_deposito
        WHERE cod_conta = NEW.cod_conta;
    RAISE INFO 'DEPOSITO EFETUADO!';
    RETURN NULL;

END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_verifica_deposito
AFTER INSERT ON deposito
FOR EACH ROW EXECUTE PROCEDURE fc_verifica_deposito();

--teste realizando deposito

SELECT * FROM conta WHERE cod_conta = 1;
SELECT * FROM deposito;

INSERT INTO deposito(cod_conta, valor_deposito) VALUES
(1, 346.50);

SELECT * FROM conta WHERE cod_conta = 1;
SELECT * FROM deposito; 


-------------- Verificar se possui saldo para transferencia e atualizar saldo do destinario --------------------

CREATE OR REPLACE FUNCTION fc_verifica_transferencia() RETURNS TRIGGER AS
$$
BEGIN
    IF(NEW.valor_transf > (SELECT (saldo+limite) FROM conta WHERE cod_conta = NEW.cod_conta_deb)) THEN
        RAISE EXCEPTION 'NÃO EXISTE SALDO SUFICIENTE PARA A TRANSFERENCIA';
    ELSE
        UPDATE conta SET saldo = saldo - NEW.valor_transf
        WHERE cod_conta = NEW.cod_conta_deb;

        UPDATE conta SET saldo = saldo + NEW.valor_transf
        WHERE cod_conta = NEW.cod_conta_cred;

        RAISE INFO 'TRANSFERENCIA REALIZADA COM SUCESSO!';

        RETURN NEW;
    END IF;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_verifica_transferencia
BEFORE INSERT ON transferencia
FOR EACH ROW EXECUTE PROCEDURE fc_verifica_transferencia();

--testando transferencia maior que saldo 

SELECT * FROM CONTA ORDER BY cod_conta;

INSERT INTO transferencia(cod_conta_deb, cod_conta_cred, valor_transf) VALUES
(1, 4, 500.00);

SELECT * FROM transferencia;
SELECT * FROM conta ORDER BY cod_conta;

--testando transferencia menor que saldo

INSERT INTO transferencia(cod_conta_deb, cod_conta_cred, valor_transf) VALUES
(1, 4, 50.00);