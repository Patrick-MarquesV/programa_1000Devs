package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex19{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        int dia, mes;

        System.out.print("Digite o dia: ");
        dia = input.nextInt();
        System.out.print("Digite o mes: ");
        mes = input.nextInt();

        System.out.printf("\nA quatidade de dias que se passaram foram: %d dias\n", ((mes-1)*30)+dia);

    }
}