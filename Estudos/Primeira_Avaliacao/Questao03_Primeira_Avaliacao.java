package programa_1000Devs.Primeira_Avaliacao;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Questao03_Primeira_Avaliacao{
    
    //variaveis declaradas globalmente para uso em ambas as classes 
    static int numero=1, idade, crianca=0, adolescentes=0, adultos=0, idosos=0, maiorIdade=0;
    static String nome, sexo, maisVelho;
    
    public static void main(String[] args) throws IOException{
        
        //chamada das funções solicitando entrada dos dados de cada individuo
        dadosIndividuos();
        dadosIndividuos();
        dadosIndividuos();
        
        //Exibe os resultados totais dos dados entrados
        System.out.println("Total de crianças: " + crianca);
        System.out.println("Total de adolescentes: "+adolescentes);
        System.out.println("Total de adultos: " + adultos);
        System.out.println("Total de melhor idade: "+idosos);
        System.out.println();
        
        System.out.println("O nome do indivíduo mais velho é: "+maisVelho);
    }
    
    //Função que solicita e classifica os dados de cada individuo 
    public static void dadosIndividuos(){
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Digite o nome do indivíduo 0%d: ", numero);
        nome = input.next();
        numero++;
        
        System.out.print("Digite a idade do "+nome+": ");
        //Exibe erro caso o tipo do dado entrado não seja inteiro
        try{
            idade = input.nextInt();
            if(idade<0){
                System.out.print("Entrar com uma idade válida: ");
                idade = input.nextInt();
            }
        }catch(InputMismatchException e){
            System.out.println("Idade inserida invalida");
        }
        
        System.out.print("Digite o sexo do(a) "+nome+": ");
        sexo = input.next();
        
        //Determina, com base na idade entrada, se é criança, adolescente, adulto ou melhor idade
        if(idade<=13){
            System.out.println(nome + " é criança");
            crianca++;
        } else if(idade<=20){
            System.out.println(nome + " é adolescente");
            adolescentes++;
        } else if(idade<=50){
            System.out.println(nome + " é adulto");
            adultos++;
        } else if(idade>50){
            System.out.println(nome + " é da melhor idade");
            idosos++;
        }
        
        //Compara a idade entrada e armazena na variavel maiorIdade para proximas comparações;
        if(idade>maiorIdade){
            maisVelho = nome;
            maiorIdade = idade;
        }
        
        System.out.println();
    }
}