// 09. Faça um algoritmo que leia os dados necessários para calcular e exibir a área:
// Pesquisa na Internet como calculcar a área de cada objeto abaixo:
// a) de um trapézio. b) de um quadrado. c) de um retangulo. d) de um círculo. e) de um triangulo
package programa_1000Devs.Encontro13_Algoritimos;
import java.io.IOException;
import java.util.Scanner;

public class Ex9{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int baseMaiorTrap, baseMenorTrap, alturaTrap, ladoQuadrado, larguraRetangulo, alturaRetangulo, raioCirculo, baseTriangulo, alturaTriangulo;

        //TRAPEZIO
        System.out.println("Area do trapezio:");
        System.out.print("Informe o valor da base maior: ");
        baseMaiorTrap = input.nextInt();
        System.out.print("Informe o valor da base menor: ");
        baseMenorTrap = input.nextInt();
        System.out.print("Informe o valor da altura: ");
        alturaTrap = input.nextInt();
        System.out.printf("A area do trapezio e: %.2f\n\n", ((baseMaiorTrap+baseMenorTrap)/2.0)*alturaTrap);
        
        //QUADRADO
        System.out.println("Area do quadrado:");
        System.out.print("Informe o valor de um dos lados: ");
        ladoQuadrado = input.nextInt();
        System.out.printf("A area do quadrado e: %.2f\n\n", ladoQuadrado*(float)ladoQuadrado);

        //RETANGULO
        System.out.println("Area do retagulo:");
        System.out.print("Informe o valor da largura: ");
        larguraRetangulo = input.nextInt();
        System.out.print("Informe o valor da altura: ");
        alturaRetangulo = input.nextInt();
        System.out.printf("A area do retangulo e: %.2f\n\n", larguraRetangulo*(float)alturaRetangulo);

        //CIRCULO
        System.out.println("Area do circulo:");
        System.out.print("Informe o valor do raio: ");
        raioCirculo = input.nextInt();
        System.out.printf("A area do circulo e: %.2f\n\n", raioCirculo*raioCirculo*3.14159f);

        //TRIANGULO
        System.out.println("Area do triangulo:");
        System.out.print("Informe o valor da base: ");
        baseTriangulo = input.nextInt();
        System.out.print("Informe o valor da altura: ");
        alturaTriangulo = input.nextInt();
        System.out.printf("A area do triangulo e: %.2f\n\n", baseTriangulo*alturaTriangulo/2.0f);
        


    }
}