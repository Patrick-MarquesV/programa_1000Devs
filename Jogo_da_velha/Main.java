package programa_1000Devs.Jogo_da_velha;
import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args)throws IOException, InterruptedException{
                
        int modoDeJogo = menu(); //EXIBE MENU E PERGUNTA O MODO DE JOGO

        switch(modoDeJogo){ // INICIA O MODO DE JOGO SELECIONADO
            case 1:
                umJogador();
                break;
            case 2:
                doisJogadores();
                break;
        }
    }

    public static void umJogador() throws IOException, InterruptedException{ //MODO DE JOGO CONTRA A MAQUINA
        
        int dificuldade = dificuldade(); //EXIBE MENU PARA SELEÇÃO DA DIFICULDADE DO COMPUTADOR
        
        String[][] arr = new String[3][3];
        
        Random generator = new Random();
        int aleatório = generator.nextInt(2); //GERA UM VALOR ALEATÓRIO ENTRE 0 E 1 PARA DETERMINAR QUEM COMEÇA

        int[] linhaColuna = {0, 0}; //ARRAY COM AS COORDENADAS QUE SERÃO JOGADAS

        int jogada = aleatório%2 == 0 ? 1 : 0; //VARIAVEL PARA CONTROLE DO NUMERO DA JOGADA EXCLUSIVO PARA O MODO DIFICIL

        imprimeArray(arr); //CHAMA METODO QUE IMPRIME A ARRAY
        
        while(true){ //LAÇO DE REPETIÇÃO QUE RODA ATÉ VITÓRIA OU EMPATE 
            
            if(aleatório%2==0){ //SE ALEATÓRIO == 0, QUEM COMEÇA É O "X"
                linhaColuna = solicitaEntrada(arr); // SOLICITA ENTRADA DO JOGADOR
                arr[linhaColuna[0]][linhaColuna[1]] = "X"; // ESCREVE O "X" NO LOCAL SELECIONADO
                aleatório++; //PASSA A VEZ PARA O COMPUTADOR

            } else{
                
                switch(dificuldade){//CHAMA A DIFICULDADE SELECIONADA
                    case 1: 
                        linhaColuna = dificuldadeFacil(arr);
                        break;
                    case 2:
                        linhaColuna = dificuldadeMedio(arr);
                        break;
                    case 3:
                        linhaColuna = dificuldadeDificil(arr, jogada, linhaColuna);
                        break;
                }
                
                arr[linhaColuna[0]][linhaColuna[1]] = "O"; //ESCREVE O "O" NO LOCAL ESCOLHIDO PELO COMPUTADOR
                
                aleatório--;//PASSA A VEZ PARA O JOGADOR
                jogada++;//INCREMENTA A VARIÁVEL DO NUMERO DE JOGADAS DO COMPUTADOR
            }

            imprimeArray(arr);//IMPRIME A NOVA ARRAY COM AS JOGADAS REALIZADAS

            if(verificaVitoria(arr, arr[linhaColuna[0]][linhaColuna[1]])){ // VERIFICA SE ALGUEM VENCEU E ENCERRA O PROGRAMA
                System.out.println("VITÓRIA DO \"" + arr[linhaColuna[0]][linhaColuna[1]]+"\"!!!!\n\n");
                break;
            } else if(verificaEmpate(arr)){ // VERIFICA EMPATE E ENCERRA O PROGRAMA
                System.out.println("EMPATE!!!\n\n");
                break;
            }
        }
        
    }

    public static int[] dificuldadeFacil(String[][] arr) throws IOException, InterruptedException{
        
        Random generator = new Random();
        int linhaAleatoria = generator.nextInt(3); // GERA UM NUMERO ALEATORIO PARA A LINHA
        int colunaAleatoria = generator.nextInt(3); // GERA UM NUMERO ALEATORIO PARA A COLUNA

        int[] linhaColuna = {linhaAleatoria, colunaAleatoria}; //ARRAY RETORNADA COM AS COORDENADAS DE LINHA X COLUNA

        return arr[linhaAleatoria][colunaAleatoria] != "X" && arr[linhaAleatoria][colunaAleatoria] != "O" ? linhaColuna : dificuldadeFacil(arr); //VERIFICA SE A SELEÇÃO REALIZADA ESTA DISPONIVEL, CASO CONTRARIO GERA UM NOVO NUMERO
    
    }

    public static int[] dificuldadeMedio(String[][] arr) throws IOException, InterruptedException{
        
        String[] contaLinha = new String[3], contaColuna = new String[3], contaDiagonalPositiva = new String[3],contaDiagonalNegativa = new String[3];

        int[] linhaColuna = {0, 0}; //ARRAY QUE SERÁ RETORNADA COM AS CORDENADAS ONDE PRECISA SER COLOCADO A "O"

        for(int k= 0; k<2 ; k++){
            String XO;
            
            
            if(k==0){ //VERIFICA PRIMEIRAMENTE SE POSSUI ALGUMA JOGADA PARA VITÓRIA, NA SEQUENCIA VERIFICA OPORTUNIDADE DE DEFESA
                XO = "O";
            } else{
                XO = "X";
            }

            for(int i = 0; i<arr.length; i++){
                for(int j = 0; j<arr.length; j++){
                        
                    contaLinha[j] = arr[i][j]; //GERA ARRAY COM OS ITENS "X", "O" OU NULL QUE ESTÃO NA LINHA

                    //AVALIA LINHAS PARA JOGAR OU DEFENDER
                    if(frequencia(contaLinha, XO) == 2 && indiceNull(contaLinha)>=0){
                        linhaColuna[0] = i;
                        linhaColuna[1] = indiceNull(contaLinha);
                        i=arr.length;
                        k=2;
                        break;
                    }

                    contaColuna[j] = arr[j][i]; //GERA ARRAY COM OS ITENS "X", "O" OU NULL QUE ESTÃO NA COLUNA

                    //AVALIA COLUNAS PARA JOGAR OU DEFENDER
                    if(frequencia(contaColuna, XO) == 2 && indiceNull(contaColuna)>=0){
                        linhaColuna[0] = indiceNull(contaColuna);
                        linhaColuna[1] = i;
                        i=arr.length;
                        k=2;
                        break;
                    }

                    //AVALIA DIAGONAL POSITIVA PARA JOGAR OU DEFENDER
                    if(i==j){
                        
                        contaDiagonalPositiva[j] = arr[j][i]; //GERA ARRAY COM OS ITENS "X", "O" OU NULL QUE ESTÃO NA DIAGONAL POSITIVA

                        if(frequencia(contaDiagonalPositiva, XO) == 2 && indiceNull(contaDiagonalPositiva)>=0){
                            linhaColuna[0] = indiceNull(contaDiagonalPositiva);
                            linhaColuna[1] = indiceNull(contaDiagonalPositiva);
                            i=arr.length;
                            k=2;
                            break;
                        }
                    }

                    //AVALIA DIAGONAL NEGATIVA PARA JOGAR OU DEFENDER
                    if(i+j==2){
                        
                        contaDiagonalNegativa[j] = arr[j][i]; //GERA ARRAY COM OS ITENS "X", "O" OU NULL QUE ESTÃO NA DIAGONAL NEGATIVA

                        if(frequencia(contaDiagonalNegativa, XO) == 2 && indiceNull(contaDiagonalNegativa)>=0){
                            linhaColuna[0] = indiceNull(contaDiagonalNegativa);
                            linhaColuna[1] = 2-indiceNull(contaDiagonalNegativa);
                            i=arr.length;
                            k=2;
                            break;
                        }
                    }
                }
            }
        }        

        //VERIFICA SE O INTERVALO SELECIONADO JÁ ESTÁ OCUPADO POR SEGURANÇA
        return arr[linhaColuna[0]][linhaColuna[1]] != "X" && arr[linhaColuna[0]][linhaColuna[1]] != "O" ? linhaColuna : dificuldadeFacil(arr);
    
    }

    public static int[] dificuldadeDificil(String[][] arr, int jogada, int[] jogadaAnterior ) throws IOException, InterruptedException{
        
        Random generator = new Random();
        int aleatorio = generator.nextInt(4);

        int[] linhaColuna = {0, 0};

        if(jogada==0){
            int[][] primeiraJogada = {{0,0}, {0,2},{1,1}, {2,0}, {2,2}};

            return linhaColuna = primeiraJogada[aleatorio];
        } 

        //Ataque
        switch(jogada){
            case 0:
                int[][] primeiraJogada = {{0,0}, {0,2},{1,1}, {2,0}, {2,2}};

                return linhaColuna = primeiraJogada[aleatorio];

            case 1:
                //if((jogadaAnterior[0]==0 && jogadaAnterior[1]==1))
                    
                //else if (jogadaAnterior[0]==1 && jogadaAnterior[1]==0)

                ////else if (jogadaAnterior[0]==1 && jogadaAnterior[1]==2)

                //else if (jogadaAnterior[0]==2 && jogadaAnterior[1]==1)


            case 2:

            case 3:

            case 4: 
        }   

        return arr[linhaColuna[0]][linhaColuna[1]] != "X" && arr[linhaColuna[0]][linhaColuna[1]] != "O" ? linhaColuna : dificuldadeMedio(arr);
    
    }

    public static int frequencia(String[] arr, String elemento){ //VERIFICA A QUANTIDADE DE "X" OU "O" NA ARRAY PASSADA
        int contador = 0;
        for(int i=0; i<arr.length; i++){ //CASO EXISTA 2 ELEMENTOS REPETIDOS O COMPUTADOR RETORNA O NUMERO 2 MOSTRANDO QUE ELE DEVE ATACAR (QUANDO 2 "O") OU DEFENDER (QUANDO 2 "X")
            if(arr[i] != null && arr[i].intern() == elemento.intern()){
                contador++;
            }
        }

        return contador;

    }

    public static int indiceNull(String[] arr){ //DETERMINA EM QUE POSIÇÃO NA ARRAY GERADA COM OS ELEMENTOS "X" OU "O" O COMPUTADOR DEVE JOGAR EX: {X, X, NULL} O COMPUTADOR DEVE DEFENDER NA POSIÇÃO 2 NULL

        StringBuilder str = new StringBuilder();

        for(String item : arr){
            str.append(item);
        }

        return str.indexOf("null"); //RETORNA O INDICE ONDE O COMPUTADOR DEVE JOGAR

    }

    public static void doisJogadores() throws IOException, InterruptedException{
        String[][] arr = new String[3][3];

        Random generator = new Random();
        int aleatório = generator.nextInt(2);//GERA UM VALOR ALEATÓRIO ENTRE 0 E 1 PARA DETERMINAR QUEM COMEÇA

        imprimeArray(arr); //CHAMA METODO QUE IMPRIME A ARRAY

        while(true){ //LAÇO DE REPETIÇÃO QUE RODA ATÉ VITÓRIA OU EMPATE 

            int[] linhaColuna = solicitaEntrada(arr); //SOLICITA ENTRADA AO JOGADOR
           
            if(aleatório%2==0){ //DETERMINA DE QUEM É A VEZ E FAZ A JOGADA
                arr[linhaColuna[0]][linhaColuna[1]] = "X";
                aleatório++;

            } else{
                arr[linhaColuna[0]][linhaColuna[1]] = "O";
                aleatório--;
            }

            imprimeArray(arr); // IMPRIME A ARRAY ATUALIZADA COM OS VALORES ENTRADOS

            if(verificaVitoria(arr, arr[linhaColuna[0]][linhaColuna[1]])){ // VERIFICA SE ALGUEM VENCEU E ENCERRA O PROGRAMA
                System.out.println("VITÓRIA DO \"" + arr[linhaColuna[0]][linhaColuna[1]]+"\"!!!!\n\n");
                break;
            } else if(verificaEmpate(arr)){ // VERIFICA EMPATE E ENCERRA O PROGRAMA
                System.out.println("EMPATE!!!\n\n");
                break;
            }

        }
    }

    public static void imprimeArray (String[][] array) throws IOException, InterruptedException { //IMPRIME ARRAY
        StringBuilder str = new StringBuilder();
        int linha = 0;
        
        limpaConsole(); //CHAMA O METODO DE LIMPEZA DO TERMINAL
        
        System.out.println("\t\t C1      C2      C3\n");

        for(String[] item : array){
            linha++;
            str.append("\tL"+linha+"\t   ");
            for(String subItem : item){
                if(subItem!=null){
                    str.append(subItem + "  |   ");
                } else{
                    str.append("   |   ");
                }
            }
            str.delete(str.length()-6, str.length());
            str.append("\n\t\t------+------+------\n");
        }
        str.delete(str.length()-21, str.length());
        str.append("\n");

        System.out.print(str.toString());
    }

    public static boolean verificaEmpate(String[][] arr){ // VERIFICA SE TODOS OS CAMPOS FORAM PREENCHIDOS COM "X" E "O" E DECLARA EMPATE
        int contador = 0;
        for(String[] item : arr){
            for(String subItem : item){
                if(subItem !=null && (subItem.intern()=="O" || subItem.intern() =="X")){
                    contador++;
                }
            }
        }
        return contador == 9 ? true : false;
    }

    public static boolean verificaVitoria(String[][] array, String XO){ //VERIFICA SE HOUVE VITORIA
        int contaLinha = 0, contaColuna = 0, contaDiagonalPositiva=0,contaDiagonalNegativa=0;

        for(int i = 0; i<array.length; i++){ //VERIFICA SE EXISTE REPETIÇÃO DE 3 ELEMENTOS NA LINHA
            for(int j = 0; j<array.length; j++){
                if(array[i][j]!= null && array[i][j].intern()==XO.intern()){
                    contaLinha++;
                    if(contaLinha==3){
                        return true;
                    }
                }
                if(array[j][i]!= null && array[j][i].intern()==XO.intern()){ //VERIFICA SE EXISTE REPETIÇÃO DE 3 ELEMENTOS NA COLUNA
                    contaColuna++;
                    if(contaColuna==3){
                        return true;
                    }
                }
                if(array[j][i]!= null && i==j && array[j][i].intern()==XO.intern()){ //VERIFICA SE EXISTE REPETIÇÃO DE 3 ELEMENTOS NA DIAGONAL POSITIVA
                    contaDiagonalPositiva++;
                    if(contaDiagonalPositiva==3){
                        return true;
                    }
                }
                if(array[j][i]!= null && i+j==2 && array[j][i].intern()==XO.intern()){ //VERIFICA SE EXISTE REPETIÇÃO DE 3 ELEMENTOS NA DIAGONAL NEGATIVA
                    contaDiagonalNegativa++;
                    if(contaDiagonalNegativa==3){
                        return true;
                    }
                }
            }
            contaColuna = 0; //REINICIA A COLUNA POIS EXISTEM 3 COLUNAS
            contaLinha = 0; //REINICIA A LINHA POIS EXISTEM 3 LINHAS
        }
        return false;
    }

    public static void limpaConsole() throws IOException, InterruptedException{//Limpa a tela no windows, no linux e no MacOS
        
        if (System.getProperty("os.name").contains("Windows")) //verifica se o SO é windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033\143"); //Limpa console em MacOS e Linux
    }

    public static boolean verificaEntrada(String[][] arr, int linha, int coluna){ // VERIFICA SE O VALOR ENTRADO NÃO ESTÁ OCUPADO E É VALIDO E RETORNA TRUE OU FALSE
        return linha<0 || linha > 3 || coluna  <0 || coluna > 3 || arr[linha][coluna]=="X" || arr[linha][coluna]=="O" ;
    }

    public static int menu() throws IOException, InterruptedException{ //IMPRIME MENU, SOLICITA ENTRADA DO MODO DE JOGO E RETORNA OPÇÃO SELECIONADA
        Scanner input = new Scanner(System.in);

        int opcao;

        limpaConsole();
        
        System.out.println("##############################");
        System.out.println("#            MENU            #");
        System.out.println("#                            #");
        System.out.println("#         1- Jogador         #");
        System.out.println("#         2- Jogadores       #");
        System.out.println("#                            #");
        System.out.println("##############################");
        System.out.println();

        System.out.print("Digite a opção desejada: ");
        opcao = input.nextInt();

        return opcao > 0 && opcao < 3 ? opcao : menu();        
    }

    public static int[] solicitaEntrada(String[][] arr){ //SOLICITA ENTRADA PARA O JOGADOR
        Scanner input = new Scanner(System.in);

        int linha, coluna;

        System.out.print("Digite dois valores separados por espaco LINHA COLUNA: ");
        linha = input.nextInt()-1;
        coluna = input.nextInt()-1;

        while(verificaEntrada(arr, linha, coluna)){ //VALIDA O VALOR ENTRADA E ENTRA EM LOOPING ATÉ COLOCAR UMA COORDENADA VALIDA E DISPONIVEL
            System.out.print("A LINHA e COLUNA digitada está ocupada ou fora do intervalo, por favor, tente novamente: ");
            linha = input.nextInt()-1;
            coluna = input.nextInt()-1;
        }

        int[] str = {linha, coluna};
       
        return str; //RETORNA COORDENADAS
    }

    public static int dificuldade() throws IOException, InterruptedException{ //IMPRIME MENU DE DIFICULDADE, SOLICITA ENTRADA DA OPÇÃO E RETORNA A OPÇAO ESCOLHIDA
        Scanner input = new Scanner(System.in);

        int opcao;

        limpaConsole();
        
        System.out.println("##############################");
        System.out.println("#    NIVEL DE DIFICULDADE    #");
        System.out.println("#                            #");
        System.out.println("#         1- Fácil           #");
        System.out.println("#         2- Médio           #");
        System.out.println("#         3- Difícil         #");
        System.out.println("#                            #");
        System.out.println("##############################");
        System.out.println();

        System.out.print("Digite a opção desejada: ");
        opcao = input.nextInt();

        return opcao > 0 && opcao < 4 ? opcao : dificuldade();        
    }

}