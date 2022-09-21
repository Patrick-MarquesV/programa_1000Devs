// 6. Faça um algoritmo para calcular quantas ferraduras são necessárias para equipar
// todos os cavalos comprados para um haras. O usuário devera informar a quantidade de
// cavalos adquirido

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex6{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int qtdCavalos;
        float valorFerradura;
        
        System.out.print("Informe quantidade de cavalos: ");
        qtdCavalos = input.nextInt();
        System.out.print("Informe o valor de cada ferradura: R$ ");
        valorFerradura = input.nextFloat();

        System.out.println("\nA quantidade de ferraduras necessarias: " + qtdCavalos*4);
        System.out.printf("Valor total para a compra das ferraduras: R$ %.2f\n", qtdCavalos*4*valorFerradura);
               

    }
}