// 7. Faça um algoritmo que receba o peso de uma pessoa, calcule e mostre:
// a) o novo peso se a pessoa engordar 15% sobre o peso digitado;
// b) o novo peso se a pessoa emagrecer 20% sobre

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex7{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int peso;

        System.out.print("Informe o peso em KG: ");
        peso = input.nextInt();

        System.out.printf("Caso a pessoa engorde 15%% ficara com: %.2f\n", peso*1.15f);
        System.out.printf("Caso a pessoa emagraça 20%% ficara com: %.2f\n", peso*0.8f);
    }

}