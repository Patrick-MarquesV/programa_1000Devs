package programa_1000Devs.Encontro23_if_else;
import java.io.IOException;
import java.util.Scanner;

public class Ex2_E23{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        float salarioMinimo, salarioFuncionario;

        System.out.print("Informe o valor do salario minimo: ");
        salarioMinimo = input.nextFloat();
        System.out.print("Informe o valor do salario do funcionario: ");
        salarioFuncionario = input.nextFloat();

        if((salarioFuncionario/salarioMinimo)>=1){
            System.out.printf("O funcionario recebe %.1f salarios minimos!\n", (salarioFuncionario/salarioMinimo));
        } else {
            System.out.printf("O funcionario ganha menos que um salario minimo!\n");
        }
        
    }
}