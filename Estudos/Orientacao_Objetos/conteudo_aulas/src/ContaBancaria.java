public class ContaBancaria {
    
    int numeroConta;
    double saldo;
    String nomeCorrentista;

    public ContaBancaria(int numeroConta, double saldo, String nomeCorrentista){
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.nomeCorrentista = nomeCorrentista;
    }

    public void saque(double valor){

        if(valor > this.saldo){
            System.out.println("Saldo insuficiente!");
        } else if(valor<0){
            System.out.println("Valor de saque inválido!");
        }else{
            this.saldo -= valor;
            System.out.println("Saque efetuado!");
        }

    }

    public void deposito(double valor){

        if(valor<0){
            System.out.println("Valor de depósito inválido!");
        } else{
            this.saldo+=valor;
            System.out.println("Deposito efetuado!");
        }

    }

    public void extrato(){

        System.out.println("Saldo da conta: R$ " + this.saldo);

    }

}
