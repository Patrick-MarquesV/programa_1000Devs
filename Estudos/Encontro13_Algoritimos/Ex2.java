// 2. Faça um algoritmo que receba o valor do salário mínimo e o valor do salário de um
// funcionário, calcule e mostre a quantidade de salários mínimos que ganha esse
// funcionário

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex2 {
    
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        
        float salarioMinimo, salarioFunc;

        System.out.print("Informe o valor do salario minimo: ");
        salarioMinimo = input.nextFloat();
        System.out.print("Informe o valor do salario do funcionario: ");
        salarioFunc = input.nextFloat();

        System.out.printf("\nO funcionario recebe %.1f salarios minimos", salarioFunc/salarioMinimo);
        

    }
    
}
