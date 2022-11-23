// 5. Faça um algoritmo que receba dois números inteiros, calcule e mostre a divisão do
// primeiro número pelo segundo. Sabe-se que o segundo número não pode ser zero, portanto não é necessário se preocupar com validações. Resultado esperado:
// OBS: Para forçar uma divisão de dois números inteiro produzir um resultado fracionário, utilizamos a palavra float entre parênteses. Exemplo: (a/(float)b). Neste caso, forçamos o
// compilador entender que a variavel b apesar de ser inteira deve s

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex5{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int num1, num2;

        System.out.print("Informe o valor 1: ");
        num1 = input.nextInt();
        System.out.print("Informe o valor 2: ");
        num2 = input.nextInt();

        System.out.printf("\nAdivisao de %d por %d e %.2f\n", num1, num2, num1/(float) num2);
        
    }
}