package mesttra;

//Os clientetes, independente do tipo, tem um número de conta,
//        agência, telefone, saldo e limite de cheque especial.

public abstract class Cliente {

    private static final int AGENCIA_PADRAO = 1;
    private static final double SALDO_INCIAL = 0;
    private static int SEQUENCIAL = 1;
    private int numeroConta;

    private int agencia;

    private String telefone;

    private double saldo;

    private double limiteChequeEspecial;

    public Cliente(String telefone, double limiteChequeEspecial) {
        this.numeroConta = SEQUENCIAL++;
        this.agencia = AGENCIA_PADRAO;
        this.telefone = telefone;
        this.saldo = SALDO_INCIAL;
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public static int getSEQUENCIAL() {
        return SEQUENCIAL;
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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
}
