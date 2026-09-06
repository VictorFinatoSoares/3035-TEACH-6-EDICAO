package exercicios.estrutura_condicional;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número INTEIRO: ");
        int num = Integer.parseInt(sc.nextLine());

        if (num % 2 == 0) {
            System.out.printf("%d é PAR!", num);
        } else {
            System.out.printf("%d é ÍMPAR!", num);
        }

        sc.close();
    }
}
