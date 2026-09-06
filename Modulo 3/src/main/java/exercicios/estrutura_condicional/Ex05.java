package exercicios.estrutura_condicional;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int num = Integer.parseInt(sc.nextLine());

        if (num >= 0) {
            System.out.printf("O dobro de %d é %d", num, num * 2);
        } else {
            System.out.printf("O triplo de %d é %d", num, num * 3);
        }

        sc.close();
    }
}
