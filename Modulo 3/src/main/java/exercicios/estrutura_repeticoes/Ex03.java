package exercicios.estrutura_repeticoes;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escreva um número de 0 a 10: ");
        int num = Integer.parseInt(sc.nextLine());

        System.out.printf("\n==== Tabuada do %d ====\n\n", num);

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", num, i, num * i);
        }

        sc.close();
    }
}
