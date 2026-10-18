package desafio;

import java.util.Scanner;

public class Jogo {
    public static  final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        iniciarJogo();
    }

    public static void iniciarJogo() {
        System.out.print("Bem vindo à Arena dos Campeões!\nDigite o seu nome: ");
        Personagem jogador = criarPersonagem();
        Inimigo oponente = new Inimigo();

        while (jogador.estaVivo() && oponente.estaVivo()) {
            exibirStatus(jogador, oponente);

            turnoDoJogador(jogador, oponente);

            if (oponente.estaVivo()) {
                turnoDoInimigo(oponente, jogador);
            }
        }
        fimDeJogo();
    }

    public static Personagem criarPersonagem() {
        String nome = sc.nextLine();
        int classe;

        while (true) {
            System.out.print("""
                    LISTA DE CLASSES:
                    \s
                    [1] Guerreiro (BÔNUS: +10 HP)
                    [2] Mago (BÔNUS: +10 ATK)
                    [3] Arqueiro (BÔNUS: +10 DEF)
                    \s
                    """);

            classe = lerInteiro("Sua escolha (1-3): ");

            if (classe < 1 || classe > 3) {
                System.out.println("ERRO: Essa classe não existe!");
                continue;
            }
            break;
        }

        return switch (classe) {
            case 1 -> new Guerreiro(nome, 100, 16, 6);
            case 2 -> new Mago(nome, 100, 16, 6);
            case 3 -> new Arqueiro(nome, 100, 16, 6);
            default -> null;
        };
    }

    public static void exibirStatus(Personagem jogador, Inimigo oponente) {
        System.out.printf("""
                SITUAÇÃO DE BATALHA:
                \s
                %s: %d HP
                %s: %d HP
                \s
                """, jogador.nome, jogador.vida, oponente.nome, oponente.vida);
    }

    public static void turnoDoJogador(Personagem jogador, Inimigo oponente) {
        System.out.println("""
               [TURNO DO JOGADOR]
                
               AÇÕES DISPONÍVEIS:
               \s
               [1] Atacar
               [2] Defender
               [3] Usar poção de cura (3 disponíveis)
               \s
               """);

        int acao = lerInteiro("Escolha sua ação (1-3): ");

        switch (acao) {
            case 1:
                int dano = jogador.atacar(oponente);
                System.out.printf("%s ataca %s! (DMG: %d)\n", jogador.nome, oponente.nome, dano);
                break;
            case 2:
                jogador.defender();
                break;
            case 3:
                System.out.println("Curando...");
                break;
            default:
                System.out.println("Essa ação não está disponível, pulando sua vez...");
        }
    }

    public static void turnoDoInimigo(Inimigo inimigo, Personagem jogador) {
        int dano = inimigo.atacar(jogador);
        System.out.printf("[TURNO DO INIMIGO]\n%s atacou %s! (DMG: %d)\n", inimigo.nome, jogador.nome, dano);
    }

    public static void fimDeJogo() {
        System.out.println("Fim de Jogo");
    }

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
