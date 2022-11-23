// 15. A empresa Hipotheticus paga R$10,00 por hora normal trabalhada, R$15,00 por hora
// extra e R$ 90 reais por cada dependente menor que 6 anos. Faça um algoritmo que
// solicite a quantidade de horas normais e extras trabalhadas no mês além da quantidade
// de dependentes menores que 6 anos. Considere que o salário líquido é igual ao salário de
// horas normais descontando-se 11% de impostos. O salário final é o salário liquido mais o
// valor recebido por cada dependente mais as horas extra

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex15{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        int horasNormais, horasExtras, dependentes;

        System.out.print("Digite a quantidade total de horas normais: ");
        horasNormais = input.nextInt();
        System.out.print("Digite a quantidade total de horas extras: ");
        horasExtras = input.nextInt();
        System.out.print("Digite a quantidade total de dependentes menores que 6 anos: ");
        dependentes = input.nextInt();

        System.out.printf("\nHoras normais: R$ %.2f\n", horasNormais*10.0f);
        System.out.printf("Adicional de Horas Extras: R$ %.2f\n", horasExtras*15.0f);
        System.out.printf("Adicional de Dependentes: R$ %.2f\n", dependentes*90.0f);
        System.out.printf("Salario Liquido (Hrs normais - Desconto): R$ %.2f\n", horasNormais*10*0.89f);
        System.out.printf("Salario final: R$ %.2f\n", horasNormais*10*0.89f+horasExtras*15.0f + dependentes*90.0f);



    }

}