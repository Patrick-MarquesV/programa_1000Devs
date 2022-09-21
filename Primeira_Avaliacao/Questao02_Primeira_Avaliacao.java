package programa_1000Devs.Primeira_Avaliacao;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Questao02_Primeira_Avaliacao{
     
    //variaveis declaradas globalmente para uso em ambas as classes 
    static int voto, candA=0, candB=0, candC=0, nulo=0, total, validos;
    
    //classe de contagem de votos
    public static void contaVotos(){
        
        Scanner input = new Scanner(System.in);
        
        //Estrutura de tratameto de exceções
        try{
            voto = input.nextInt();
            
            //Estrura de decisão que emite mensagem caso o valor digitado seja diferente do exibido no menu de votação
            if(voto<1 || voto>4){
                System.out.println("Opção inválida o voto não será computado");
            }
            
        }catch(InputMismatchException e){ //Exibe mensagem no caso de entrada com tipo incopativel com a variavel int
            System.out.println("Opção inválida o voto não será computado");
        }
        
        //Estrutura de contabilização dos votos com base em seus valores
        switch(voto){
            case 1: 
               candA++;
               break;
            case 2: 
                candB++;
                break;
            case 3:
                candC++;
                break;
            case 4:
                nulo++;
                break;
        }
        
        total = candA+candB+candC+nulo; //Soma os votos totais
        validos = total-nulo; //Soma dos votos validos, não entrando os nulos
    }
    
    public static void main(String[] args) throws IOException{
        
        //Exibe menu de votação
        System.out.println("=========== Menu de Votação ===========");
        System.out.println("1 - Candidato A");
        System.out.println("2 - Candidato B");
        System.out.println("3 - Candidato C");
        System.out.println("4 - Voto Nulo");
        System.out.println("=======================================");
        
        //Solicita a entrada dos votos e chama a função contaVotos
        System.out.print("Digite o código do candidato para o primeiro voto: ");
        contaVotos();
        System.out.print("Digite o código do candidato para o segundo voto: ");
        contaVotos();
        System.out.print("Digite o código do candidato para o terceiro voto: ");
        contaVotos();
        System.out.print("Digite o código do candidato para o quarto voto: ");
        contaVotos();
        System.out.print("Digite o código do candidato para o quinto voto: ");
        contaVotos();
        
        //Caso totos os valores inseridos sejam invalidos, modifica total para 1, a fim de preservar a formatação das saidas
        if(total<=0){
            total =1;
        }
        
        //Exibe os resultados finais percentuais.
        System.out.printf("Percentual de Votos Válidos: %.1f%%\n",(float)validos/total*100);
        System.out.printf("Percentual de Votos Candidato A: %.1f%%\n", (float)candA/total*100);
        System.out.printf("Percentual de Votos Candidato B: %.1f%%\n", (float)candB/total*100);
        System.out.printf("Percentual de Votos Candidato C: %.1f%%\n", (float)candC/total*100);
        System.out.println();
        
        //Estrutura de decisão que exibe o resultado da votação;
        if(candA>candB && candA>candC){
            System.out.println("Candidato vencedor: Candidato A");
        }else if(candB>candC){
            System.out.println("Candidato vencedor: Candidato B");
        } else if(candC>candA && candC>candB){
            System.out.println("Candidato vencedor: Candidato C");
        } else{
            System.out.println("Empate");
        }
        
    }
}