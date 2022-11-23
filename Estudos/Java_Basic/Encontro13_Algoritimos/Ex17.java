// 17. Uma padaria vende uma certa quantidade de pães franceses e uma quantidade de
// broas a cada dia. Cada pãozinho custa R$ 0,12 e a broa custa R$ 1,60. Ao final do dia, o
// dono quer saber quanto arrecadou com a venda dos pães e broas (juntos), e quanto deve
// guardar numa conta de poupança (10% do total arrecadado) para realizar uma reforma. Você foi contratado para fazer os cálculos para o dono. Com base nestes fatos, faça um
// algoritmo para ler as quantidades de pães e de broas, o valor da reforma e depois calcule
// o valor arrecado, o valor a ser depositado na poupança e quantos dias serão necessários, caso mantenha o mesmo faturamento, para custear a reforma. 
// Requisito adicional: A quantidade de dias deve ser retornado como um valor inteiro. 
// Exemplo: 3.78 dias deverá retornar 4 dias
// 9.2 dias deverá retornar 10 dias
// 10.89 dias deverá retornar 11 dias 

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class Ex17{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int qtdPaes, qtdBroas;
        double valorReforma, fatPaes, fatBroas, deposito, dias;

        System.out.print("Digite a quantidade de paes vendidos: ");
        qtdPaes = input.nextInt();
        System.out.print("Digite a quantidade de broas vendidos: ");
        qtdBroas = input.nextInt();
        System.out.print("Digite a quantidade de broas vendidos: ");
        valorReforma = input.nextDouble();
        
        fatPaes = qtdPaes*0.12;
        fatBroas = qtdBroas*1.60;
        deposito = (fatBroas+fatPaes)*0.10;
        dias = valorReforma/deposito;

        System.out.printf("\nFaturamento com a venda de broas: %.2f\n", fatBroas);
        System.out.printf("Faturamento com a venda de paes: %.2f \n", fatPaes);
        System.out.printf("Faturamento diario (paes + broas): %.2f\n", fatBroas+fatPaes);
        System.out.printf("Valor do deposito na poupanca: %.2f\n", deposito);
        System.out.printf("Para pagar a reforma serao necessarios: %d dias\n", (int) Math.ceil(dias));

    }
}