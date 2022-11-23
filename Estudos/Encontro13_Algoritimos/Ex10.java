// 10. Faça um algoritmo que receba o ano de nascimento de uma pessoa e o ano atual, calcule e mostre. a) a idade dessa pessoa em anos;
// b) a idade dessa pessoa em meses;
// c) a idade dessa pessoa em dias; considere todos os meses com 30 dias
// d) a idade dessa pessoa em semanas, considere que todos os messes possuem 4
// semanas

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex10{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        
        int anoInicial, anoFinal, idadeAnos, idadeMeses, idadeDias, idadeSemanas;    

        System.out.print("Digite o ano incial: ");
        anoInicial = input.nextInt();
        System.out.print("Digite o ano final: ");
        anoFinal = input.nextInt();

        idadeAnos = anoFinal-anoInicial;
        idadeMeses = idadeAnos*12;
        idadeDias = idadeMeses*30;
        idadeSemanas = idadeMeses*4;

        System.out.println("\nA idade desta pessoa em");
        System.out.println("anos e: " + idadeAnos);
        System.out.println("meses e: " + idadeMeses);
        System.out.println("dias e: " + idadeDias);
        System.out.println("semanas e: " + idadeSemanas);
    }
}