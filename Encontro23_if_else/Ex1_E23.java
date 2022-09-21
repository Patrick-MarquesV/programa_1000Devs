// Questão 01: Uma imobiliária vende apenas terrenos retangulares. Faça um algoritmo para
// imprimir a área do terreno e o valor de venda do mesmo. Para isto será necessário o usuário
// informar as dimensões em metros (frente e lateral) do terreno além do valor cobrado pelo metro
// quadrado. Caso a diferença de metragem entre a frente e a lateral seja menor que 10% da
// metragem da frente, o cliente terá um acréscimo de 22% no valor final do terreno.
// Caso a metragem da frente for menor que 40% da lateral, o cliente terá um desconto de 12% no
// valor final do terreno. Caso a metragem da frente for maior que 70% da lateral, o cliente terá um
// desconto de 15%. Caso as medidas não encaixem em nenhuma das regras o valor final do
// terreno não sofrerá alterações.

package programa_1000Devs.Encontro23_if_else;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class Ex1_E23{
    public static void main(String[] main) throws IOException{
        Scanner input = new Scanner(System.in);

        double frente, lateral, area, valor, total;

        System.out.print("Quantos metros o terreno possui de frente: ");
        frente = input.nextDouble();
        System.out.print("Quantos metros o terreno possui de lateral: ");
        lateral = input .nextDouble();
        System.out.print("Informe o valor do metro quadrado: ");
        valor = input.nextDouble();

        area = lateral*frente;
        total = area*valor;
        
        System.out.printf("Area total do terreno de %.2f mts de frente com %.2f mts de lateral e: %.2f\n", frente, lateral, area);

        if(Math.abs(frente-lateral)<0.1*frente){
            total*=1.22;
            System.out.printf("O terreno recebeu um acrescimo de 22%% e custara: R$ %.2f\n", total);
        } else if(frente<(0.4*lateral)){
            total*=0.88;
            System.out.printf("O terreno recebeu um decrescimo de 12%% e custara: R$ %.2f\n", total);
        } else if(frente>0.7*lateral){
            total*= 0.85;
            System.out.printf("O terreno recebeu um decrescimo de 15%% e custara: R$ %.2f\n", total);
        } else{
            System.out.printf("O terreno não recebeu nenhuma alteração e custara: R$ %.2f\n", total);
        }
    }    
}
