/* CRIAÇÃO DE TABELAS */

/* Produto (Codigo_P, Descricao, Quantidade, Valor_Unit, EstoqueMinimo); */

CREATE TABLE IF NOT EXISTS produto (
	codigo_p SERIAL PRIMARY KEY,
	descricao VARCHAR(100) NOT NULL,
	quantidade NUMERIC(15, 3) NOT NULL,
	valor_unit NUMERIC(15, 2) NOT NULL,
	estoque_minimo NUMERIC(15, 3) NOT NULL,
	/* Produtos não devem aceitar Valor_Unit menor que 0 (zero); */
	CHECK (valor_unit >= 0),
	/* Produtos não devem aceitar Quantidade menor que 0 (zero); */
	CHECK (quantidade >= 0)
);

/* Cliente (Codigo_C, Nome, Endereco, CPF); */

CREATE TABLE IF NOT EXISTS cliente (
	codigo_c SERIAL PRIMARY KEY,
	nome VARCHAR(150) NOT NULL,
	endereco VARCHAR(200),
	cpf VARCHAR(14) NOT NULL UNIQUE
);

/* Fornecedor (Codigo_F, Razao_Social, CPNJ); */

CREATE TABLE IF NOT EXISTS fornecedor (
	codigo_f SERIAL PRIMARY KEY,
	razao_social VARCHAR(150) NOT NULL,
	endereco VARCHAR(200),
	cnpj VARCHAR(18) NOT NULL UNIQUE
);

/* Compra (Codigo_Comp, Data_C, Codigo_F, Valor_Total); */

CREATE TABLE IF NOT EXISTS compra (
	codigo_comp SERIAL PRIMARY KEY,
	data_comp DATE DEFAULT (CURRENT_DATE),
	codigo_f INTEGER REFERENCES fornecedor NOT NULL,
	valor_total NUMERIC(15, 2) DEFAULT 0
);

/* Itens_Compra (Codigo_Comp, Codigo_P, Quantidade, Valor_Unit); */

CREATE TABLE IF NOT EXISTS itens_compra (
	codigo_comp INTEGER REFERENCES compra,
	codigo_p INTEGER REFERENCES produto,
	quantidade NUMERIC(15, 3) NOT NULL,
	valor_unit NUMERIC(15, 2) NOT NULL,
	PRIMARY KEY (codigo_comp, codigo_p),
	CHECK (quantidade > 0),
	CHECK (valor_unit >= 0)
);

/* Venda (Codigo_V, Data_V, Codigo_C, Valor_Total, Parcelas); */

CREATE TABLE IF NOT EXISTS venda (
	codigo_v SERIAL PRIMARY KEY,
	data_v TIMESTAMP DEFAULT NOW(),
	codigo_c INTEGER NOT NULL,
	valor_total NUMERIC(15, 2) DEFAULT 0,
	parcelas INTEGER DEFAULT 1,
	CHECK (parcelas > 0)
);

/* Adicionar referencia a tabela de cliente */

ALTER TABLE venda 
ADD CONSTRAINT fc_codigo_c_cliente 
FOREIGN KEY (codigo_c) 
REFERENCES cliente; 

/* Itens_Venda (Codigo_V, Codigo_P, Quantidade, Valor_Unit); */

CREATE TABLE IF NOT EXISTS itens_venda (
	codigo_v INTEGER REFERENCES venda,
	codigo_p INTEGER REFERENCES produto,
	quantidade NUMERIC(15, 3) NOT NULL,
	valor_unit NUMERIC(15, 2),
	PRIMARY KEY (codigo_v, codigo_p),
	CHECK (quantidade > 0)
);

/* Historico_Valor_Produto */ 

CREATE TABLE IF NOT EXISTS historico_valor_produto (
    codigo_h SERIAL PRIMARY KEY,
    codigo_p INTEGER REFERENCES produto NOT null,
    valor_unit NUMERIC(15,2) NOT null,
    data_alteracao DATE DEFAULT CURRENT_DATE
);

/*controle de pagamentos*/

CREATE TABLE IF NOT EXISTS pagamento (
    codigo_v INTEGER REFERENCES venda,
    nro_parcela INTEGER,
    data_venc DATE NOT NULL,
    data_pagto DATE,
    valor_parc NUMERIC(15,2) NOT NULL,
    valor_pago NUMERIC(15,2),
    PRIMARY KEY (codigo_v, nro_parcela),
    CHECK(valor_parc >= 0)
);

/* regra noticia estoque minimo de produto */
/*Armazenar alterações do valor_unit em Historico_valor_produto*/


CREATE OR REPLACE FUNCTION fc_estoque_minimo() RETURNS TRIGGER AS
$$
BEGIN
    IF ( (SELECT quantidade FROM produto WHERE codigo_p = NEW.codigo_p)<=
        (SELECT estoque_minimo FROM produto WHERE codigo_p = NEW.codigo_p)) THEN
        
        RAISE NOTICE 'Produto atingiu estoque mínimo!';

	END IF;

	IF( NEW.valor_unit != OLD.valor_unit) THEN
		INSERT INTO historico_valor_produto(codigo_p, valor_unit) VALUES
		(NEW.codigo_p, OLD.valor_unit);
		RAISE NOTICE 'Valor unitario alterado e registrado em histórico!';
    END IF;

    RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_estoque_minimo 
AFTER UPDATE ON produto
FOR EACH ROW EXECUTE PROCEDURE fc_estoque_minimo();

/*testando regra*/
SELECT * FROM produto ORDER BY codigo_p;

INSERT INTO produto(descricao, quantidade, valor_unit, estoque_minimo) VALUES
('Lápis 2B', 100, 0.49, 50),
('Borracha com capa', 50, 2.49, 20),
('Régua 30cm transparente', 40, 1.99, 20);

UPDATE produto
SET quantidade = quantidade + 80
WHERE codigo_p = 1;

UPDATE produto
SET valor_unit = 0.59
WHERE codigo_p = 1;

SELECT * FROM historico_valor_produto;

/* Compras devem alterar o estoque*/


CREATE OR REPLACE FUNCTION fc_compra_produto() RETURNS TRIGGER AS
$$
BEGIN
	UPDATE produto SET quantidade = quantidade + NEW.quantidade WHERE codigo_p = NEW.codigo_p;

	UPDATE compra SET valor_total = valor_total + (NEW.quantidade * NEW.valor_unit) WHERE codigo_comp = new.codigo_comp;
	RAISE INFO 'ESTOQUE E COMPRA ATUALIZADOS!';

	RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_compra_produto
AFTER INSERT ON itens_compra
FOR EACH ROW EXECUTE PROCEDURE fc_compra_produto();

SELECT * FROM itens_compra;
SELECT * FROM compra;

INSERT INTO fornecedor (razao_social, cnpj) VALUES
('Faber Castel', '11.222.333/0001-00');

INSERT INTO compra (codigo_f) VALUES
(1);

INSERT INTO itens_compra VALUES
(1, 1, 32, 0.24); 
INSERT INTO itens_compra VALUES
(1, 2, 16, 1.64); 
INSERT INTO itens_compra VALUES
(1, 3, 7, 1.19); 


-- CREATE OR REPLACE FUNCTION fc_historico_valor_produto() RETURNS TRIGGER AS 
-- $$
-- BEGIN



-- END;
-- $$
-- LANGUAGE plpgsql;

-- CREATE TRIGGER tr_historico_valor_produto
-- AFTER UPDATE ON produto
-- FOR EACH ROW EXECUTE PROCEDURE fc_historico_valor_produto();