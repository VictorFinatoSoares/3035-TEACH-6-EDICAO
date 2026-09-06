package exercicios.estrutura_condicional;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe A: ");
        int a = Integer.parseInt(sc.nextLine());

        System.out.print("Informe B: ");
        int b = Integer.parseInt(sc.nextLine());

        int c;

        if (a == b) {
            c = a + b;
        } else {
            c = a * b;
        }

        System.out.printf("Resultado: %d", c);

        sc.close();
    }
}
