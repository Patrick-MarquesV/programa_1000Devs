/*
1. Uma imobiliária vende apenas terrenos retangulares. Faça um algoritmo para imprimir a
área do terreno e o valor de venda do mesmo. Para isto será necessário o usuário
informar as dimensões em metros (frente e lateral) do terreno além do valor cobrado pelo
metro quadrado.
 */

 // teste de alteraçãoS

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

 public class Ex1{
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        float dimFrente, dimLateral, valorMetro;

        System.out.print("Quantos metros o terreno possui de frente: ");
        dimFrente = input.nextFloat();
        System.out.print("QUantos metros o terreno possui de lateral ");
        dimLateral = input.nextFloat();
        System.out.print("Informe o valor do metro quadrado: ");
        valorMetro = input.nextFloat();

        System.out.printf("Area total do terreno de %.2f mts de frente com %.2f mts de lateral e: %.2f mts\n", dimFrente, dimLateral, dimLateral*dimFrente);
        System.out.printf("O valor desse terreno e: R$ %.2f\n", dimFrente*dimLateral*valorMetro);


    }

 }