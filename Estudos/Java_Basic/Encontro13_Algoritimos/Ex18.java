// 18. Três amigos, Carlos, André e Felipe. decidiram rachar igualmente a conta de um bar. Faça um algoritmo para ler o valor total da conta e imprimir quanto cada um deve pagar, mas faça com que Carlos e André não paguem centavos. Ex: uma conta de R$101,53
// resulta em R$33,00 para Carlos, R$33,00 para André e R$35,53 para Felip

package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex18{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        float valorConta, felipe;
        int carlosAndre;

        System.out.print("Informe o valor da conta R$: ");
        valorConta = input.nextFloat();

        carlosAndre = (int) (valorConta/3.0f);

        felipe = valorConta - (carlosAndre*2);

        System.out.printf("\nCarlos pagara: R$ %d\n", carlosAndre);
        System.out.printf("Andre pagara: R$ %d\n", carlosAndre);
        System.out.printf("Felipe pagara: R$ %.2f\n", felipe);
    }
}