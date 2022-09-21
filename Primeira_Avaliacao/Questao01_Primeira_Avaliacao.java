package programa_1000Devs.Primeira_Avaliacao;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Questao01_Primeira_Avaliacao{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        
        int saque=0;
        
        System.out.print("Digite a quantidade de dinheiro a ser sacada: ");
        try{
            saque = input.nextInt();
            
            if(saque<=0 || saque%5 != 0){ //Exibe mensagem e solicita nova entrada para valores iguais ou inferiores a zera e que nao sejam divisiveis por 5
                System.out.print("\nValor precisa ser maior do que 0 e multiplo de 5 (cinco), insira novamente: ");
                saque = input.nextInt();
            }
            
        }catch(InputMismatchException e){ //Exibe mensagem caso o tipo de valor digitado seja uma letra ou simbolo
            System.out.println("O valor de entrada deve ser numerico, inteiro, maior do que 0 (zero) e multiplo de 5 (cinco)");
        }
        
        
        //calcula a quantidade de notas e subtrai o valor das notas do total para ir para a proxima nota.
        System.out.println("Quantidades");
        System.out.println("100 reais: " + saque/100);
        saque -=(saque/100)*100;
        System.out.println("50 reais: " + saque/50);
        saque -=(saque/50)*50;
        System.out.println("20 reais: " + saque/20);
        saque -=(saque/20)*20;
        System.out.println("10 reais: " + saque/10);
        saque -=(saque/10)*10;
        System.out.println("5 reais: " + saque/5);
        saque -=(saque/5)*5;
    }
}