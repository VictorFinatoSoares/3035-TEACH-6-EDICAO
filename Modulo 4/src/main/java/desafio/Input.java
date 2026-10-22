package desafio;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);
    public static int lerInteiro(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Você precisa digitar um número inteiro.");
            }
        }
    }

    public static String lerLinha(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

}
