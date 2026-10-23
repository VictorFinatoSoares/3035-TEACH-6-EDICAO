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
        while (true) {
            System.out.print(msg);
            String entrada = sc.nextLine();

            // Não retorna a entrada se ela estiver vazia ou só com espaços em branco
            if (!entrada.isBlank()) {
                return entrada;
            } else {
                System.out.println("Você precisa escrever algo!");
            }
        }
    }
}
