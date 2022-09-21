package programa_1000Devs.Primeira_Avaliacao;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Questao04_Primeira_Avaliacao{
    
    //variaveis declaradas globalmente para uso em ambas as classes
    static int numero=1, pagamento;
    static float valor, aVista=0, parcelado=0, desconto=0, juros=0;
    
    public static void main(String[] args) throws IOException{
        
        //Exibe as condições de pagamento
        System.out.println("========Códigos de classificação========");
        System.out.println("1 À vista, com 8% de desconto");
        System.out.println("2 À vista no cartão, 4% de desconto");
        System.out.println("3 Em 2x, preço normal sem juros");
        System.out.println("4 Em 4x, preço acrescido de 8%");
        System.out.println("========================================");
        System.out.println();
        
        //chama a função de processamento e entrada de dados das compras
        dadosCompras();//1
        dadosCompras();//2
        dadosCompras();//3
        dadosCompras();//4
        dadosCompras();//5
        
        //Exibe o resultado acumulado das cinco compras
        System.out.printf("Total de compras \"À vista\": R$ %.2f\n", aVista);
        System.out.printf("Total de compras \"parceladas\": R$ %.2f\n", parcelado);
        System.out.println();
        
        System.out.printf("Total de descontos: R$ %.2f\n", desconto);
        System.out.printf("Total de Juros: R$ %.2f\n", juros);
        
    }
    
    //Função para processamento e entrada dos dados das compras
    public static void dadosCompras(){
        Scanner input = new Scanner(System.in);
        
        //Solicita entrada dos dados das compras
        System.out.println("Compra 0"+numero);
        numero++;
        System.out.print("Digite o valor total: R$ ");
        
        //Exibe mensagem no caso de entrada com tipo incopativel com a variavel float
        try{
            valor = input.nextFloat();
        }catch(InputMismatchException e){
            System.out.println("Valor inválido, a compra não será processada");
        }
        
        System.out.print("Digite a forma de pagamento: ");
        
        //Exibe mensagem no caso de entrada com tipo incopativel com a variavel int
        try{
            pagamento = input.nextInt();
        }catch(InputMismatchException e){
            System.out.println("\nOpção inválida, a compra não será processada");
        }
        
        //classifica os pagamentos conforme condições de pagamento
        switch(pagamento){
            case 1:
                desconto += valor*0.08f;
                valor*=0.92f;
                aVista+=valor;
                System.out.println("Desconto de 8%");
                System.out.printf("Valor final: R$ %.2f\n", valor);
                break;
            case 2: 
                desconto += valor*0.04f;
                valor*=0.96f;
                aVista+=valor;
                System.out.println("Desconto de 4%");
                System.out.printf("Valor final: R$ %.2f\n", valor);
                break;
            case 3:
                parcelado+=valor;
                System.out.printf("Em 2x de R$ %.2f\n", valor/2);
                System.out.printf("Valor final: R$ %.2f\n", valor);
                break;
            case 4:
                juros = valor*0.08f;
                valor*=1.08f;
                parcelado+=valor;
                System.out.printf("Em 4x de R$ %.2f\n", valor/4);
                System.out.printf("Valor final: R$ %.2f\n", valor);
                break;
            default:
                System.out.println("Opção inválida, a compra não será processada");
                break;
        }
        
        System.out.println();
    }
    
}