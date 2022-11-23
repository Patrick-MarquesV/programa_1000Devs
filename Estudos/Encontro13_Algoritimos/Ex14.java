// 14. A lanchonete Gostosura vende apenas um tipo de sanduíche, cujo recheio inclui duas
// fatias de queijo, uma fatia de presunto e uma rodela de hambúrguer. Sabendo que cada
// fatia de queijo ou presunto pesa 50 gramas, e que a rodela de hambúrguer pesa 120
// gramas, faça um algoritmo em que o dono forneça a quantidade de sanduíches a fazer, e
// a máquina informe as quantidades (em quilos) de queijo, presunto e carne necessários
// para compra.

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex14{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        int qtdSanduiche;
        float pesoMussarela, pesoPresunto, pesoHamburguer;

        System.out.print("Digite a quantidade de sanduiches: ");
        qtdSanduiche = input.nextInt();

        pesoMussarela = qtdSanduiche*2*0.050f;
        pesoPresunto = qtdSanduiche*0.050f;
        pesoHamburguer = qtdSanduiche*0.12f;

        System.out.printf("\nPara produzir %d sanduiches serao necessarios: \n", qtdSanduiche);
        System.out.printf("%.2f kgs de mussarela\n", pesoMussarela);
        System.out.printf("%.2f kgs de presunto\n", pesoPresunto);
        System.out.printf("%.2f kgs de hamburguer\n", pesoHamburguer);


    }
}