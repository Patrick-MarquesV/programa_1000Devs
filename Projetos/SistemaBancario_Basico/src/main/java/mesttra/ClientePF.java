package mesttra;

//Os clientes PF tem no seu cadastro o cpf, nome e idade.

public class ClientePF extends Cliente{

    private static final String CONTAPF = "PF";

    private static int SEQUENCIAL = 1;
    private String cpf;

    private String nome;

    private int idade;


    public ClientePF(String cpf, String nome, int idade, String telefone, double limiteChequeEspecial) {
        super(telefone, limiteChequeEspecial);
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        super.tipoConta = CONTAPF;
        super.numeroConta = SEQUENCIAL++;
    }


    @Override
    public String toString() {
        return  "   Tipo de conta = " + tipoConta + "\n" +
                "   Numero da Conta = " + super.getNumeroConta() + "\n" +
                "   CPF = " + cpf + "\n" +
                "   Nome = " + nome + "\n" +
                "   Idade = " + idade + "\n" +
                "   Agencia = " + super.getAgencia() + "\n"  +
                "   Telefone = " + super.getTelefone() + "\n" +
                "   Saldo = R$ " + super.getSaldo() + "\n" +
                "   Limite Cheque Especial = R$ " + super.getLimiteChequeEspecial() + "\n\n";
    }
}
