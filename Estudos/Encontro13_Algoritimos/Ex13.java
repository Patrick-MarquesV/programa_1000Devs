// 13. A fábrica de refrigerantes Meia-Cola vende seu produto em três formatos: lata de 350
// ml, garrafa de 600 ml e garrafa de 2 litros. Se um comerciante compra uma determinada
// quantidade de cada formato, faça um algoritmo para calcular quantos litros de refrigerante
// ele comprou

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex13{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int qtdLatas, qtdGarrafas600, qtdGarrafas2;

        System.out.print("Digite a quantidade de latas de 350ml: ");
        qtdLatas = input.nextInt();
        System.out.print("Digite a quantidade de garrafas de 600ml: ");
        qtdGarrafas600 = input.nextInt();
        System.out.print("Digite a quantidade de garrafas de 2lts: ");
        qtdGarrafas2 = input.nextInt();

        System.out.printf("\nA quantidade total de litros e: %.2f lts\n", qtdLatas*0.35+qtdGarrafas600*0.6+qtdGarrafas2*2);
        
    }

}