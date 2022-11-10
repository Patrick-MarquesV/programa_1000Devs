package mesttra;

//Os clientes PF tem no seu cadastro o cpf, nome e idade.

public class ClientePF extends Cliente{

    private String cpf;

    private String nome;

    private int idade;

    @Override
    public String toString() {
        return  "   Numero da Conta = " + super.getNumeroConta() + "\n" +
                "   CPF = " + cpf + "\n" +
                "   Nome = " + nome + "\n" +
                "   Idade = " + idade + "\n" +
                "   Agencia = " + super.getAgencia() + "\n"  +
                "   Telefone = " + super.getTelefone() + "\n" +
                "   Saldo = " + super.getSaldo() + "\n" +
                "   Limite Cheque Especial = " + super.getLimiteChequeEspecial() + "\n\n";
    }

    public ClientePF(String cpf, String nome, int idade, String telefone, double limiteChequeEspecial) {
        super(telefone, limiteChequeEspecial);
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }
}
