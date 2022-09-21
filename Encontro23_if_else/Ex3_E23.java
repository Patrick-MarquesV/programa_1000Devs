package programa_1000Devs.Encontro23_if_else;
import java.io.IOException;
import java.util.Scanner;

public class Ex3_E23 {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        int valor1, valor2;

        System.out.print("Informe o valor 1: ");
        valor1 = input.nextInt();
        System.out.print("Informe o valor 2: ");
        valor2 = input.nextInt();

        if(valor2 == 0 || valor1 == 0){
            System.out.println("A operação não pode ser realizada");
        } else if(valor1>=valor2){
            System.out.printf("A divisao de %d por %d e %.2f\n", valor1, valor2, (float)valor1/valor2);
        } else{
            System.out.printf("A divisao de %d por %d e %.2f\n", valor2, valor1, (float)valor2/valor1);
        }
    }
}
