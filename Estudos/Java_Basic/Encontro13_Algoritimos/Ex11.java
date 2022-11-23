// 11. Um tonel de refresco é feito com 8 partes de água mineral e 2 partes de suco de
// maracujá. Faça um algoritmo para calcular quantos litros de água e de suco são
// necessários para se fazer uma certa quantidade de litros de refresco informados pelo
// usuário

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex11{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        int qtdSuco;

        System.out.print("Digite a QTDE de lts de suco necessaria: ");
        qtdSuco = input.nextInt();

        System.out.printf("\nSera necessario para fazer %d lts de suco de maracuja: \n", qtdSuco);
        System.out.printf("%.2f lts de agua\n", qtdSuco*0.8);
        System.out.printf("%.2f lts de suco concentrado de maracuja\n", qtdSuco*0.2);
        

    }

}