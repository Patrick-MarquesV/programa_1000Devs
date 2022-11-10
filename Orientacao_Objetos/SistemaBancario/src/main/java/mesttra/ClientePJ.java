package mesttra;

import java.util.Arrays;

//Os clientes PJ tem no seu cadastro o cnpj, nomes dos sócios(até 3), razão social e nome fantasia.
public class ClientePJ extends  Cliente{

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
    }

    @Override
    public String toString() {
        return  "   Numero da Conta = " + super.getNumeroConta() + "\n" +
                "   CNPJ = " + cnpj + "\n" +
                "   Nome Socio = " + Arrays.toString(nomeSocio) + "\n" +
                "   Nome Social = " + nomeSocial + "\n" +
                "   Nome Fantasia = " + nomeFantasia + "\n" +
                "   Agencia = " + super.getAgencia() + "\n"  +
                "   Telefone = " + super.getTelefone() + "\n" +
                "   Saldo = " + super.getSaldo() + "\n" +
                "   Limite Cheque Especial = " + super.getLimiteChequeEspecial() + "\n\n";
    }
}
