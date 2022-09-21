package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex20{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int numero,  milhares, centena, dezena, unidade;

        System.out.print("Digite um numero de 4 digitos: ");
        numero = input.nextInt();
        milhares = (numero - numero%1000);
        centena = (numero -milhares - numero%100);
        dezena = numero - milhares - centena - numero%10;
        unidade = numero - milhares - centena - dezena;

        System.out.println("Milhares: " + milhares/1000);
        System.out.println("Centenas: " + centena/100);
        System.out.println("Dezenas: " + dezena/10);
        System.out.println("Unidade: " + unidade);
    }

}