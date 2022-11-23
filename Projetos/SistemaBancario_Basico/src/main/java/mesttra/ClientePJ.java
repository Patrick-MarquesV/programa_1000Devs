package mesttra;

import java.util.Arrays;

//Os clientes PJ tem no seu cadastro o cnpj, nomes dos sócios(até 3), razão social e nome fantasia.
public class ClientePJ extends  Cliente{

    private static final String CONTAPJ = "PJ";

    private static int SEQUENCIAL = 1;
    private String cnpj;

    private String[] nomeSocio;

    private String nomeSocial;

    private  String nomeFantasia;


    public ClientePJ(String cnpj, String[] nomeSocio, String nomeSocial, String nomeFantasia, String telefone, double limiteChequeEspecial) {
        super(telefone, limiteChequeEspecial);
        this.cnpj = cnpj;
        this.nomeSocio = nomeSocio;
        this.nomeSocial = nomeSocial;
        this.nomeFantasia = nomeFantasia;
        super.tipoConta = CONTAPJ;
        super.numeroConta = SEQUENCIAL++;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNomeSocio(String[] nomeSocio) {
        this.nomeSocio = nomeSocio;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        return  "   Tipo de conta = " + tipoConta + "\n" +
                "   Numero da Conta = " + super.getNumeroConta() + "\n" +
                "   CNPJ = " + cnpj + "\n" +
                "   Nome Socio = " + Arrays.toString(nomeSocio) + "\n" +
                "   Nome Social = " + nomeSocial + "\n" +
                "   Nome Fantasia = " + nomeFantasia + "\n" +
                "   Agencia = " + super.getAgencia() + "\n"  +
                "   Telefone = " + super.getTelefone() + "\n" +
                "   Saldo = R$ " + super.getSaldo() + "\n" +
                "   Limite Cheque Especial = R$ " + super.getLimiteChequeEspecial() + "\n\n";
    }
    public String getTipoConta() {
        return tipoConta;
    }
}
