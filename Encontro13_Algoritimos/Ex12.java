// 12. A granja Frangotech possui um controle automatizado de cada frango da sua
// produção. No pé direito do frango há um anel com um chip de identificação; no pé
// esquerdo são dois anéis para indicar o tipo de alimento que ele deve consumir. Sabendo
// que o anel com chip custa R$4,00 e o anel de alimento custa R$3,50, faça um algoritmo
// para calcular o gasto total da granja para marcar todos os seus frangos que deverá ser
// informado pelo usuário

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex12{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        int qtdeFrangos;

        System.out.print("Digite a QTDE de frangos: ");
        qtdeFrangos = input.nextInt();

        System.out.printf("\nO valor total para identificar os frangos e: R$ %.2f\n", qtdeFrangos*(4+2*3.5));

    }
}