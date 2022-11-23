// 3. Faça um algoritmo para ler três notas de um aluno em uma disciplina e imprimir a sua
// média ponderada (as notas tem pesos respectivos de 1

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex3{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        float nota1, nota2, nota3;

        System.out.print("Informe a nota 1: ");
        nota1 = input.nextFloat();
        System.out.print("Informe a nota 2: ");
        nota2 = input.nextFloat();
        System.out.print("Informe a nota 3: ");
        nota3 = input.nextFloat();

        System.out.printf("\nA media ponderada das notas %.1f, %.1f, %.1f e: %.2f\n", nota1, nota2, nota3, (nota1+nota2*2+nota3*3)/6.0f);
        
    }
}