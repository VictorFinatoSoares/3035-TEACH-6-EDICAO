package exercicios.exceptions.ex03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        try {
            System.out.print("Digite um número: ");
            num = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ERRO: Você precisa informar um NÚMERO INTEIRO!");
        } finally {
            System.out.printf("Número: %d\nPrograma finalizado!\n", num);
        }
        sc.close();
    }
}
