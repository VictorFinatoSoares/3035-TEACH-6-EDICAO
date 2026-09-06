package exercicios.estrutura_sequencial;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o primeiro número: ");
        double num1 = Double.parseDouble(sc.nextLine());

        System.out.print("Informe o segundo número: ");
        double num2 = Double.parseDouble(sc.nextLine());

        double resultado = num1 + num2;
        System.out.printf("%.2f + %.2f = %.2f", num1, num2, resultado);

        sc.close();
    }
}
