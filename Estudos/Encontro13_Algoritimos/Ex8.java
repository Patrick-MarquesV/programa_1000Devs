// 8. Faça um algoritmo para ler o salário de um funcionário e aumentá-Io em 15%. Após o
// aumento, desconte 11% de INSS e 8% de FGTS. Imprima o salário inicial, o salário com o
// aumento, o salário final, o desconto do INSS, o desconto do FGTS e o Total de Descontos
// (INSS+FGTS).

package programa_1000Devs.Encontro13_Algoritimos;

import java.io.IOException;
import java.util.Scanner;

public class Ex8{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        float salario, salarioReajustado;

        System.out.print("Informe o salario: ");
        salario = input.nextFloat();

        salarioReajustado = salario*1.15f;

        System.out.printf("\nSalario Inicial: %.2f\n", salario);
        System.out.printf("Salario reajustado: %.2f\n", salarioReajustado);
        System.out.printf("Desconto 11%% INSS: %.2f\n", salarioReajustado*0.11f);
        System.out.printf("Desconto 8%% FGTS: %.2f\n", salarioReajustado*0.08f);
        System.out.printf("Total Descontos INSS+FGTS: %.2f\n", salarioReajustado*0.19f);
        System.out.printf("Salario Final: %.2f\n", salarioReajustado*(0.81f));
    }
}