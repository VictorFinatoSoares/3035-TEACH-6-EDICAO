package exercicios.estrutura_condicional;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe A: ");
        int a = Integer.parseInt(sc.nextLine());

        System.out.print("Informe B: ");
        int b  = Integer.parseInt(sc.nextLine());

        System.out.print("Informe C: ");
        int c = Integer.parseInt(sc.nextLine());

        if (a + b < c) {
            System.out.println("A + B é menor que C.");
        }

        sc.close();
    }
}
