package mesttra;

//Os clientetes, independente do tipo, tem um número de conta,
//        agência, telefone, saldo e limite de cheque especial.

import java.util.Comparator;

public abstract class Cliente {

    private static final int AGENCIA_PADRAO = 1;
    private static final double SALDO_INCIAL = 0;

    protected int numeroConta;

    private int agencia;

    private String telefone;

    private double saldo;

    private double limiteChequeEspecial;

    protected String tipoConta;

    public Cliente(String telefone, double limiteChequeEspecial) {
        this.agencia = AGENCIA_PADRAO;
        this.telefone = telefone;
        this.saldo = SALDO_INCIAL;
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public String getTelefone() {
        return telefone;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
}

class comparatorTipoNumeroConta implements Comparator<Cliente> {

    @Override
    public int compare(Cliente cliente1, Cliente cliente2) {

        boolean clienteNotNull = cliente1 != null && cliente2 !=null;

        if(clienteNotNull){
            int tipoConta = cliente1.getTipoConta().compareToIgnoreCase(cliente2.getTipoConta());
            if (tipoConta != 0) return tipoConta;
            int numeroConta = Integer.compare(cliente1.getNumeroConta(), cliente2.getNumeroConta());

            return numeroConta;
        }

        return 0;

    }
}