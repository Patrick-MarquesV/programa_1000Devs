import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static CidadeDAO cidadeDAO = new CidadeDAO();

    public static void main(String[] args) throws SQLException {

        int entrada = 0;

        while (entrada!=4){

            System.out.println("==== MENU ====");
            System.out.println("1 - Cadastrar cidade");
            System.out.println("2 - Remover cidade");
            System.out.println("3 - Visualizar cidades");
            System.out.println("4 - Sair");
            System.out.println();

            System.out.print("Selecione uma das opções acima: ");
            entrada = entradaInt();
            menu(entrada);

        }

    }

    public static int entradaInt(){
        try{
            int opcao = input.nextInt();
            input.nextLine();
            return opcao;
        } catch (InputMismatchException e){
            System.err.println("O valor digitado deve ser inteiro!");
            System.err.println(e.getMessage());
            input.nextLine();
            return 0;
        }
    }

    public static long entradaLong(){
        try{
            long opcao = input.nextLong();
            input.nextLine();
            return opcao;
        } catch (InputMismatchException e){
            System.err.println("O valor digitado deve ser inteiro!");
            System.err.println(e.getMessage());
            input.nextLine();
            return 0;
        }
    }

    public static double entradaDouble(){
        try{
            double opcao = input.nextDouble();
            input.nextLine();
            return opcao;
        } catch (InputMismatchException e){
            System.err.println("O valor digitado deve ser um número!");
            System.err.println(e.getMessage());
            input.nextLine();
            return 0;
        }
    }

    public static boolean entradaBoolean(){
        try{
            boolean opcao = input.nextBoolean();
            input.nextLine();
            return opcao;
        } catch (InputMismatchException e){
            System.err.println("O valor digitado deve ser um true ou false!");
            System.err.println(e.getMessage());
            input.nextLine();
            return false;
        }
    }

    public static void menu(int entrada){
        switch (entrada){
            case 1:
                cadastraCidade();
                break;
            case 2:
                deletaCidade();
                break;
            case 3:
                exibiCidades();
                break;
            case 4:
                System.out.println("Obrigado por usar nosso sistema!");
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }
    }

    private static void exibiCidades() {
        System.out.println("==== Exibir cidades ====");
        cidadeDAO.findCidade();
    }

    private static void deletaCidade() {
        System.out.println("==== Deletar Cidade ====");
        System.out.print("Digite o DDD da cidade: ");
        int ddd = entradaInt();

        cidadeDAO.deletaCidade(ddd);

    }

    private static void cadastraCidade() {

        System.out.println("==== Cadastro Cidade ====");
        System.out.println("Digite os dados solicitados abaixo:");
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Numero de habitantes: ");
        long nroHabitantes = entradaLong();
        System.out.print("Renda per capita: ");
        double rendaPerCapita = entradaDouble();
        System.out.print("Capital (true ou false):  ");
        boolean capital = entradaBoolean();
        System.out.print("Estado: ");
        String estado = input.nextLine();
        System.out.print("Nome do Prefeito: ");
        String nomePrefeito = input.nextLine();

        Cidade jundiai = new Cidade(nome,nroHabitantes,rendaPerCapita,capital,estado,nomePrefeito);

        cidadeDAO.insereCidade(jundiai);
    }


}