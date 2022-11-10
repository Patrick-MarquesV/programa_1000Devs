package mesttra;

//        O gerente é capaz de cadastrar novos clientes (ler todas as informações do teclado);
//        remover clientes de sua carteira pelo número de conta (ler o número do teclado);
//        consultar cliente pelo número da conta (ler o número do teclado);
//
//        aumentar e diminuir o limite do cheque especial do cliente (ler todas as informações do teclado);
//
//        fazer transferências entre seus clientes (somente se o cliente que transfere tiver saldo)
//        (ler todas as informações do teclado);
//
//        adicionar saldo a um cliente (somente valores positivos) (ler todas as informações do teclado);
//
//        imprimir um relatório com todos os seus clientes (em tela);


public interface Gerente {

    public void cadastrarCliente();

    public void cadastrarClientePF();

    public void cadastrarClientePJ();

    public void removerCliente();

    public void consultarCliente();

    public void alterarLimite();

    public void transferir();

    public void depositar();

    public void listarClientes();

}
