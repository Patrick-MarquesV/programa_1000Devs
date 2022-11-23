package programa_1000Devs.Encontro23_if_else;
import java.io.IOException;
import java.util.Scanner;

public class Ex4_E23 {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        int cavalos;
        float valor;

        System.out.print("Informe a quantidade de cavalos: ");
        cavalos = input.nextInt();
        System.out.print("Informe o valor de cada ferradura: R$ ");
        valor = input.nextFloat();

        valor = cavalos*4*valor;

        System.out.println("A quantidade de ferraduras necessarias: "+(cavalos*4));

        if(valor < 15000){
            System.out.printf("Valor total para a compra das ferraduras: R$ %.2f\n", (valor));
        } else if(valor <= 20000){
            System.out.printf("Valor total para a compra das ferraduras: R$ %.2f\n", (valor*0.9f));
        } else if(valor <= 25000){
            System.out.printf("Valor total para a compra das ferraduras: R$ %.2f\n", (valor*0.88f));
        } else if(valor <= 30000){
            System.out.printf("Valor total para a compra das ferraduras: R$ %.2f\n", (valor*0.85f));
        } else if(valor > 30000){
            System.out.printf("Valor total para a compra das ferraduras: R$ %.2f\n", (valor*0.80f));
        }



    }
}
