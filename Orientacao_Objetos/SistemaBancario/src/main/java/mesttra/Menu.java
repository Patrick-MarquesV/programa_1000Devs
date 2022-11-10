package mesttra;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements Gerente{

    Scanner input = new Scanner(System.in);

    Cliente[] listaCliente = new Cliente[50];

    public String entradaString(){

        String entrada;

        try{
            return entrada = input.nextLine();
        } catch(NullPointerException e){
            System.out.println("Valor inserido não pode ser nulo!");
            e.printStackTrace();
        }

        return null;
    }

    public int inicio() {
        System.out.println("==== Menu Principal ====");
        System.out.println();
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Remover Cliente");
        System.out.println("3 - Consultar Cliente");
        System.out.println("4 - Alterar Limite");
        System.out.println("5 - Transferir");
        System.out.println("6 - Depositar");
        System.out.println("7 - Relatório de Clientes");
        System.out.println("8 - Sair");
        System.out.println();
        System.out.println("==========================");

        System.out.println();
        System.out.print("Digite a opção desejada: ");
        int entrada = entradaInteiro();

        opcaoEscolhida(entrada);

        return entrada;

    }

    private void opcaoEscolhida(int entrada) {

        switch (entrada){
            case 1:
                cadastrarCliente();
                break;
            case 2:
                removerCliente();
                break;
            case 3:
                verificaCliente();
                pressEnterToContinue();
                break;
            case 4:
                alterarLimite();
                break;
            case 5:
                transferir();
                break;
            case 6:
                depositar();
                break;
            case 7:
                listarClientes();
                pressEnterToContinue();
                break;
            case 8:
                System.out.println("Obrigado por utilizar nosso sistema!");
                break;
            default:
                System.out.println("Opção inserida inválida!");

        }
    }

    public double entradaDouble(){

        double entrada;

        try{
            entrada = input.nextDouble();
            input.nextLine();
            return entrada;
        } catch (InputMismatchException e){
            System.out.println("O valor inserido deve ser um número!");
            e.printStackTrace();
        }

        return 0;
    }

    public int entradaInteiro() {

        int entrada;

        try {
            entrada = input.nextInt();
            input.nextLine();
            return entrada;
        } catch (InputMismatchException e) {
            System.out.println("O valor inserido deve ser um número inteiro!");
            e.printStackTrace();
        }
        return 0;
    }
    public void cadastrarCliente() {

        System.out.println("===== Cadastro Cliente =====");
        System.out.println("Selecione uma opção: ");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.println("============================");

        System.out.println();
        System.out.print("Digite a opção desejada: ");
        int tipoCliente = entradaInteiro();

        switch (tipoCliente){
            case 1:
                cadastrarClientePF();
                break;
            case 2:
                cadastrarClientePJ();
                break;
            default:
                System.out.println("Valor inserido inválido!");
        }


    }

    public void cadastrarClientePF() {
        System.out.println("===== Cadastro Cliente Pessoa Física =====");

        System.out.println("Digite abaixo os dados, conforme solicitado: ");

        System.out.print("CPF: ");
        String cpf = entradaString();

        System.out.print("Nome: ");
        String nome = entradaString();

        System.out.print("Idade: ");
        int idade = entradaInteiro();

        System.out.print("Telefone: ");
        String telefone = entradaString();

        System.out.print("Limite de cheque especial: ");
        double limiteChequeEspecial = entradaDouble();

        adicionaClienteLista(new ClientePF(cpf, nome, idade, telefone, limiteChequeEspecial) {
        });

        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void adicionaClienteLista(Cliente novoCliente){

        for (int i=0; i<listaCliente.length; i++) {
            if(listaCliente[i]==null){
                listaCliente[i] = novoCliente;
                break;
            }
        }

    }

    public void cadastrarClientePJ() {
        System.out.println("===== Cadastro Cliente Pessoa Jurídica =====");

        System.out.println("Digite abaixo os dados, conforme solicitado: ");

        System.out.print("CNPJ: ");
        String cnpj = entradaString();

        System.out.print("Digite o número de Sócios: ");
        int numeroSocio = entradaInteiro();

        String[] nomeSocio = new String[numeroSocio];

        for(int i = 1; i<=numeroSocio; i++){
            System.out.print("Digite o nome do sócio n° " + i + " : ");
            nomeSocio[i] = entradaString();
        }

        System.out.print("Nome social: ");
        String nomeSocial = entradaString();

        System.out.print("Nome fantasia: ");
        String nomeFantasia = entradaString();

        System.out.print("Telefone: ");
        String telefone = entradaString();

        System.out.print("Limite de cheque especial: ");
        double limiteChequeEspecial = entradaDouble();

        adicionaClienteLista(new ClientePJ(cnpj, nomeSocio, nomeSocial, nomeFantasia, telefone, limiteChequeEspecial));

        System.out.println("Cliente cadastrado com sucesso!");

    }

    public void removerCliente(){
        System.out.println("==== Remover Cliente ====");
        System.out.print("Digite o número da conta: ");
        int numeroConta = entradaInteiro();
        boolean clienteRemovido = false;

        for(int i= 0; i<listaCliente.length; i++){
            if(listaCliente[i]!=null && listaCliente[i].getNumeroConta()==numeroConta){
                listaCliente[i]=null;
                System.out.println("Cliente removido com sucesso!");
                clienteRemovido = true;
                break;
            }
        }
        if(!clienteRemovido) System.out.println("Cliente não existe!");

    }

    public void consultarCliente(){

        System.out.println("===== Consulta de cliente ====");
        Cliente cliente = verificaCliente();

        if(cliente!=null){
            System.out.println(cliente.toString());
        } else {
            System.out.println("Cliente não existe!");
        }

    }

    private Cliente verificaCliente() {
        System.out.print("Digite o número da conta do cliente: ");
        int numeroConta = entradaInteiro();

        if(numeroContaExiste(numeroConta)){
            return retornaCliente(numeroConta);
        }
        return null;
    }

    public Cliente retornaCliente(int numeroConta){

        for(int i = 0; i<listaCliente.length; i++){

            if(listaCliente[i]!=null && listaCliente[i].getNumeroConta() == numeroConta){
                return listaCliente[i];
            }

            if(i==listaCliente.length-1){
                System.out.println("Cliente não existe!");
            }
        }
        return null;
    }

    public boolean numeroContaExiste(int numeroConta){

        for(int i = 0; i<listaCliente.length; i++){

            if(listaCliente[i]!=null && listaCliente[i].getNumeroConta() == numeroConta){
                return true;
            }

            if(i==listaCliente.length-1){
                System.out.println("Cliente não existe!");
            }

        }
        return false;

    }

    public void alterarLimite(){
        System.out.println("==== Alterar limite cheque especial ====");
        Cliente cliente = verificaCliente();

        System.out.print("Digite o novo limite de cheque especial: ");
        double novoLimite = entradaDouble();

        while (novoLimite<0){
            System.out.println("Insira um valor positivo!");
            novoLimite = entradaDouble();
        }

        if(cliente != null) {
            cliente.setLimiteChequeEspecial(novoLimite);
            System.out.println("Limite alterado com sucesso!");
        } else {
            System.out.println("Transação cancelada!");
        }

    }

    public void transferir(){
        System.out.println("==== Transferência ====");

        System.out.print("Conta de origem: ");
        Cliente origem = verificaCliente();

        System.out.print("Conta de destino: ");
        Cliente destino  = verificaCliente();

        System.out.print("Valor a ser transferido: ");
        double valorTransferencia = entradaDouble();

        boolean contaExiste = origem!=null && destino!=null;

        if(contaExiste && origem.getSaldo() < valorTransferencia){
            System.out.println("Saldo insuficiente!");
        } else if(contaExiste){

            origem.setSaldo(origem.getSaldo()-valorTransferencia);

            destino.setSaldo(destino.getSaldo()+valorTransferencia);

            System.out.println("Transferência concluída!");
        } else {
            System.out.println("Transação cancelada!");
        }
    }

    public void depositar(){
        System.out.println("==== Deposito ====");
        Cliente cliente = verificaCliente();

        System.out.print("Valor a ser depositado: ");
        double valorDeposito = entradaDouble();

        if(cliente != null){
            cliente.setSaldo(cliente.getSaldo() + valorDeposito);

            System.out.println("Deposito efetuado!");
        } else {
            System.out.println("Transação cancelada!");
        }

    }

    public void listarClientes(){

        System.out.println("==== Lista de Clientes ====");

        int contador = 1;

        for(Cliente cliente :
             listaCliente) {
           if(cliente!=null) {
               System.out.println("Cliente n° " + contador++ + ": ");
               System.out.println(cliente.toString());

           }
        }


    }


    private void pressEnterToContinue(){
        System.out.println("Pressione Enter duas vezes para continuar...");
        try
        {
            System.in.read();
            input.nextLine();
        } catch(Exception e)
        {
            System.out.println("Algo deu errado!");
        }
    }

}
