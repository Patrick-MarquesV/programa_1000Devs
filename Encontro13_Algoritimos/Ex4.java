// 4. Faça um algoritmo que calcule e mostre a tabuada de (+, -, * e /) de um número
// digitado pelo usuário.
// Resultado esperado:
// OBS: Quando se calcula em uma substração um numero menor de um número maior (ex:
// 3 - 10) o resultado será um número negativo. Pesquise como desprezar o sinal negatio
// para sempre termos um número positivo.

//NOTA: OBRIGATÓRIO USAR APENAS CONCEITOS BÁSICOS DE PROGRAMAÇÃO.

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class Ex4{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int num, acumulador=0;

        System.out.print("Informe o numero para o calculo da tabuada: ");
        num = input.nextInt();

        System.out.println("Tabuada do + e - para o numero " + num + " :");
        System.out.printf("%d + %d = %d \t %d - %d = %d\n", num, acumulador,  num+acumulador, num, acumulador, Math.abs(num-acumulador));
        acumulador++;
        System.out.printf("%d + %d = %d \t %d - %d = %d\n", num, acumulador,  num+acumulador, num, acumulador, Math.abs(num-acumulador));
        acumulador++;
        System.out.printf("%d + %d = %d \t %d - %d = %d\n", num, acumulador,  num+acumulador, num, acumulador, Math.abs(num-acumulador));
        acumulador++;
        System.out.printf("%d + %d = %d \t %d - %d = %d\n", num, acumulador,  num+acumulador, num, acumulador, Math.abs(num-acumulador));
        acumulador++;
        System.out.printf("%d + %d = %d \t %d - %d = %d\n", num, acumulador,  num+acumulador, num, acumulador, Math.abs(num-acumulador));
        acumulador++;
        System.out.printf("%d + %d = %d \t %d - %d = %d\n", num, acumulador,  num+acumulador, num, acumulador, Math.abs(num-acumulador));
        acumulador++;
        System.out.printf("%d + %d = %d \t %d - %d = %d\n", num, acumulador,  num+acumulador, num, acumulador, Math.abs(num-acumulador));
        acumulador++;
        System.out.printf("%d + %d = %d \t %d - %d = %d\n", num, acumulador,  num+acumulador, num, acumulador, Math.abs(num-acumulador));
        acumulador++;
        System.out.printf("%d + %d = %d \t %d - %d = %d\n", num, acumulador,  num+acumulador, num, acumulador, Math.abs(num-acumulador));
        acumulador++;
        System.out.printf("%d + %d = %d \t %d - %d = %d\n", num, acumulador,  num+acumulador, num, acumulador, Math.abs(num-acumulador));
        acumulador = 0;

        System.out.println("Tabuada da * e / para o numero " + num + ":");
        System.out.printf("%d * %d = %d \t %d / %d = nao existe divisao por zero\n", num, acumulador,  num*acumulador, num, acumulador);
        acumulador++;
        System.out.printf("%d * %d = %d \t %d / %d = %.2f\n", num, acumulador,  num*acumulador, num, acumulador, (float) num/ (float) acumulador);
        acumulador++;
        System.out.printf("%d * %d = %d \t %d / %d = %.2f\n", num, acumulador,  num*acumulador, num, acumulador, (float) num/ (float) acumulador);
        acumulador++;
        System.out.printf("%d * %d = %d \t %d / %d = %.2f\n", num, acumulador,  num*acumulador, num, acumulador, (float) num/ (float) acumulador);
        acumulador++;
        System.out.printf("%d * %d = %d \t %d / %d = %.2f\n", num, acumulador,  num*acumulador, num, acumulador, (float) num/ (float) acumulador);
        acumulador++;
        System.out.printf("%d * %d = %d \t %d / %d = %.2f\n", num, acumulador,  num*acumulador, num, acumulador, (float) num/ (float) acumulador);
        acumulador++;
        System.out.printf("%d * %d = %d \t %d / %d = %.2f\n", num, acumulador,  num*acumulador, num, acumulador, (float) num/ (float) acumulador);
        acumulador++;
        System.out.printf("%d * %d = %d \t %d / %d = %.2f\n", num, acumulador,  num*acumulador, num, acumulador, (float) num/ (float) acumulador);
        acumulador++;
        System.out.printf("%d * %d = %d \t %d / %d = %.2f\n", num, acumulador,  num*acumulador, num, acumulador, (float) num/ (float) acumulador);
        acumulador++;
        System.out.printf("%d * %d = %d \t %d / %d = %.2f\n", num, acumulador,  num*acumulador, num, acumulador, (float) num/ (float) acumulador);
        acumulador = 0;

    }

}