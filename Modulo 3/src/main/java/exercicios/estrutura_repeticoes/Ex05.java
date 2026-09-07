package exercicios.estrutura_repeticoes;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int userNum = Integer.parseInt(sc.nextLine());

        for (int i = 0; i <= userNum; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        sc.close();
    }
}
