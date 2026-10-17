package desafio;

import java.util.Scanner;

public class Jogo {
    public static  final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        iniciarJogo();
    }

    public static void iniciarJogo() {
        System.out.print("Bem vindo à Arena dos Campeões!\nDigite o seu nome: ");
        String nome = sc.nextLine();

        while (true) {
            System.out.print("""
                     LISTA DE CLASSES:
                     \s
                     [1] Guerreiro
                     [2] Mago
                     [3] Arqueiro
                    """);

            int opcao = lerInteiro("Sua escolha (1-3): ");

            if (opcao == 1) {

            }
        }


    }

    public static void exibirStatus() {}

    public static void turnoDoJogador() {}

    public static void turnoDoInimigo() {}

    public static void fimDeJogo() {}

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
}
