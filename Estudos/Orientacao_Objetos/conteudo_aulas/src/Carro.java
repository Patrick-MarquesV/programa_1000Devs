
public class Carro {

    String nome;
    double peso;
    String fabricante;
    String cor;
    double valor;

    public Carro(String nome, double peso, String fabricante, String cor, double valor){
        this.nome = nome;
        this.peso = peso;
        this.fabricante = fabricante;
        this.cor = cor;
        this.valor = valor;
    }    

    public void pintar(String novaCor){
        System.out.println("Cor original: " + this.cor);
        this.cor = novaCor;
        System.out.println("Nova cor: " + this.cor);
    }

    public void darDesconto(double desconto){
        if(desconto > this.valor*0.2){
            System.out.println("Desconto superior ao permitido!");
        } else{
            System.out.println("Valor original: R$ " + this.valor);
            this.valor -= desconto;
            System.out.println("Valor com desconto: R$ " + this.valor);    
        }
    }

    

}   
