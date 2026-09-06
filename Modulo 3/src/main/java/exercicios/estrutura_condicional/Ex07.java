package exercicios.estrutura_condicional;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe A: ");
        int a = Integer.parseInt(sc.nextLine());

        System.out.print("Informe B: ");
        int b  = Integer.parseInt(sc.nextLine());

        System.out.print("Informe C: ");
        int c = Integer.parseInt(sc.nextLine());

        if (a > b && a > c) {
            if (b > c) System.out.printf("%d, %d, %d\n", a, b, c);
            else System.out.printf("%d, %d, %d\n", a, c, b);
        } else if (b > a && b > c) {
            if (a > c) System.out.printf("%d, %d, %d\n", b, a, c);
            else System.out.printf("%d, %d, %d\n", b, c, a);
        } else {
            if (b > a) System.out.printf("%d, %d, %d\n", c, b, a);
            else System.out.printf("%d, %d, %d\n", c, a, b);
        }

    }
}
