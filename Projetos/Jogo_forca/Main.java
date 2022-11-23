package programa_1000Devs.Jogo_forca;
import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;
import java.io.File;
import java.text.Normalizer;
import java.util.Random;

public class Main{
    public static void main(String[] args) throws IOException, InterruptedException{

        int tentativas = 6; //NUMERO DE TENTATIVAS
        int score=0; //VARIAVEL PARA FINALIZAR O PROGRAMA COM VITÓRIA OU DERROTA

        StringBuilder letrasTentadas = new StringBuilder(); //STRING COM AS LETRAS QUE JA FORAM INSERIDAS PELO USUARIO
        String palavra = selecionaPalavra(); //CHAMA O METODO QUE ESCOLHE ALEATORIAMENTE A PALVRA DENTRO DO ARQUIVO texto.txt

        String[] arrPalavra = palavra.split(""); //TRANSFORMA A PALAVRA ESCOLHIDA EM ARRAY PARA COMPARAÇÃO FUTURA
        String[] palavraEncriptada = new String[arrPalavra.length]; //DECLARAÇÃO DA ARRAY QUE SERÁ USADA PARA MOSTRAR AS LETRAS ACERTADAS PELO USUARIOS

        for(int i=0; i<palavraEncriptada.length; i++){
            palavraEncriptada[i]="*"; //INICIALIZA A ARRAY COM "*"
        }

        //LAÇO DE REPETIÇÃO COM BASE NO NUMERO DE TENTATIVAS
        while(tentativas>0){

            limpaConsole(); // FUNÇÃO QUE LIMPA O CONSOLE

            String chute;
            Boolean flag = false;

            Scanner input = new Scanner(System.in);

            System.out.println("=== Bem vindo ao jogo da forca ===\n");
            System.out.println("Tentativas restantes: " + tentativas);
            System.out.println("Letras tentadas: " + letrasTentadas);

            System.out.print("Palavra a ser descoberta: ");

            for(String item : palavraEncriptada){ //IMPRIME A ARRAY QUE VAI EXIBIR AS POSIÇÕES DAS LETRAS ACERTADAS
                System.out.print(item + " ");
            }

            System.out.println();

            System.out.print("Digite uma letra: ");
            
            chute  = input.nextLine().toLowerCase(); //LE A LETRA INSERIDA PELO USUARIO
            letrasTentadas.append(chute+" "); //ARMAZENA A LETRA PARA MOSTRAR QUE JÁ FOI USADA;

            for(int i=0;i<arrPalavra.length; i++){ //LAÇO QUE COMPARA O PALPITE DO USUARIO COM AS LETRAS DA PALAVRA
                if(chute.intern() == arrPalavra[i].intern() && arrPalavra[i].intern()!=palavraEncriptada[i].intern()){
                    palavraEncriptada[i] = arrPalavra[i];
                    flag = true; //FLAG PARA SABER SE ENTROU OU NÃO DENTRO DESSA CONDICIONAL
                    score++; //ACUMULADOR DO SCORE QUE DIZ SE O USUARIO ACERTOU TODAS OU NAO 
                }
            }

            if(!flag){ //CASO NÃO TENHA ENTRADO NA CONDICIONAL SIGNIFICA QUE O USUARIO ERROU E DESCONTA A TENTATIVA
                tentativas--;
            }

            limpaConsole();

            if(score == arrPalavra.length){ //VERIFICA SE ATINGIU O SCORE (ACERTOU TODAS AS LETRAS) E EXIBE MENSAGEM
                System.out.println("\n\nParabéns você descobriu a palavra!!!\n");
                System.out.println("\tPalavra: " + palavra.toUpperCase() + "\n\n");
                break; //SAI DO LOOP WHILE POIS O USUARIO VENCEU

            } else if(tentativas==0){
                System.out.println("\n\nVocê perdeu!!!\n");
                System.out.println("\tPalavra: " + palavra.toUpperCase() + "\n\n");
            }
        }
    }

    public static void limpaConsole() throws IOException, InterruptedException{
        //Limpa a tela no windows, no linux e no MacOS
        if (System.getProperty("os.name").contains("Windows")) //verifica se o SO é windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033\143"); //Limpa console em MacOS e Linux
    }

    public static String selecionaPalavra() throws IOException, InterruptedException{
        File file = new File("programa_1000Devs/Jogo_forca/texto.txt"); //inicializa o arquivo texto.txt
        Scanner input = new Scanner(file);

        String palavra ="";

        Random generator = new Random();
        int aleatorio = generator.nextInt(72); // gera um numero aleatória que será a linha da palavra escolhida

        while(aleatorio > 0){ //laço para ir até a linha do numero aleatorio gerado
            palavra = input.next().toLowerCase();
            
            aleatorio--;
        }
        return removerAcentos(palavra); //retorna a palavra que esta na linha selecionada com a acentuação removida
    }

    public static String removerAcentos(String stringAcentuada) throws IOException, InterruptedException {
        if (stringAcentuada == null){
            return null;
        }
        return Normalizer.normalize(stringAcentuada, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");//REMOVE ACENTUAÇÃO ATRAVES DO NORMALIZER E DE REGEX ASCII
    }
}