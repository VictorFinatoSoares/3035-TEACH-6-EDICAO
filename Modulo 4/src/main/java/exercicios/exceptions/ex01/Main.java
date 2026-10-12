package exercicios.exceptions.ex01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int a = Integer.parseInt(sc.nextLine());
            int b = Integer.parseInt(sc.nextLine());

            System.out.printf("%d dividido por %d é %d\n", a, b, a / b);

        } catch (ArithmeticException e) {
            System.out.println("ERRO: Divisão por ZERO!");
        } catch (NumberFormatException e) {
            System.out.println("ERRO: Você precisa informar NÚMEROS INTEIROS!");
        }
        sc.close();
    }
}
