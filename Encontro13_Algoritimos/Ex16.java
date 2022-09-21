// 16. Uma loja de decoração precisa aumentar o seu faturamento para o próximo mês em
// 20%. Esta loja deseja atingir este objetivo aumentando a venda de três produtos. O
// produto 1 custa R$ 150 o produto 2 R$ 220,00 e o produto 3 R$ 97.00. Faça um algoritmo
// que receba o valor de faturamento do último mês e apresente:
// a) O faturamento do próximo mês para bater a meta de 20%. 
// b) A quantidade de peças apenas do produto 1 necessárias para obter a meta desejada. 
// c) A quantidade de peças apenas do produto 2 necessárias para obter a meta desejada. 
// d) A quantidade de peças apenas do produto 3 necessárias 

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex16{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        float faturamentoAnterior, meta, qtdPeca1, qtdPeca2, qtdPeca3;

        System.out.print("Digite o valor do faturamento anterior: ");
        faturamentoAnterior = input.nextFloat();

        meta = faturamentoAnterior*1.20f;
        qtdPeca1 = (meta-faturamentoAnterior)/150.0f;
        qtdPeca2 = (meta-faturamentoAnterior)/220.0f;
        qtdPeca3 = (meta-faturamentoAnterior)/97.0f;
        
        System.out.printf("\nA meta do proximo mes e: R$ %.2f\n", meta);
        System.out.printf("Um aumento de: R$ %.2f\n", meta-faturamentoAnterior);
        System.out.printf("Quantidade de pecas a serem vendidas para atingirmos a meta: \n\n");
        System.out.printf("Produto 1: %.2f pecas\n", qtdPeca1);
        System.out.printf("Produto 2: %.2f pecas\n", qtdPeca2);
        System.out.printf("Produto 3: %.2f pecas\n", qtdPeca3);


    }
}