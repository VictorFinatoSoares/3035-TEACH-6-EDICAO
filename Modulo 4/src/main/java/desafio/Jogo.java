package desafio;

import java.util.Scanner;

public class Jogo {
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
            exibirStatus(jogador, oponente);

            if (!oponente.estaVivo()) {
                System.out.printf("%s foi derrotado!\n", oponente.getNome());
                break;
            }

            turnoDoInimigo(oponente, jogador);

            if (!jogador.estaVivo()) {
                System.out.printf("%s foi derrotado!\n", jogador.getNome());
                exibirStatus(jogador, oponente);
            }
        }

        fimDeJogo(jogador, oponente);
    }

    public static Personagem criarPersonagem() {
        String nome = Input.lerLinha("Informe seu nome: ");
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

            classe = Input.lerInteiro("Sua escolha (1-3): ");

            if (classe < 1 || classe > 3) {
                System.out.println("ERRO: Essa classe não existe!");
                continue;
            }
            break;
        }


        Personagem jogador;
        switch (classe) {
            case 1 -> jogador = new Guerreiro(nome, 100, 16, 6);
            case 2 -> jogador = new Mago(nome, 100, 16, 6);
            case 3 -> jogador = new Arqueiro(nome, 100, 16, 6);
            default -> throw new IllegalStateException("Classe validada fora das opções disponíveis.");
        }

        for (int i = 0; i < 3; i++) {
            jogador.adicionarItem("Poção de Cura");
        }

        return jogador;
    }

    public static void exibirStatus(Personagem jogador, Inimigo oponente) {
        System.out.printf("""
                \s
                SITUAÇÃO DE BATALHA:
                \s
                %s: %d HP
                %s: %d HP
                \s
                """, jogador.getNome(), jogador.getVida(), oponente.getNome(), oponente.getVida());
    }

    public static void turnoDoJogador(Personagem jogador, Inimigo oponente) {
        while (true) {
            System.out.printf("""
                \s
                [TURNO DO JOGADOR]
                \s
                AÇÕES DISPONÍVEIS:
                \s
                [1] Atacar
                [2] Defender (Reduz o dano do próximo ataque pela metade)
                [3] Usar poção de cura (%d disponíveis)
                \s
                """, jogador.contarItem("Poção de Cura"));

            int acao = Input.lerInteiro("Escolha sua ação (1-3): ");

            switch (acao) {
                case 1:
                    int dano = jogador.atacar(oponente);
                    System.out.printf("%s ataca %s! (DMG: %d)\n", jogador.getNome(), oponente.getNome(), dano);
                    return;
                case 2:
                    jogador.defender();
                    System.out.printf("%s se defende. O próximo dano recebido será reduzido pela metade.\n", jogador.getNome());
                    return;
                case 3:
                    String mensagemErro = jogador.mensagemErroCura();

                    if (!mensagemErro.isEmpty()) {
                        System.out.println(mensagemErro);
                        continue;
                    }
                    int vidaRecuperada = jogador.usarPocaoCura();
                    System.out.printf("%s se curou! (+%d HP)\n", jogador.getNome(), vidaRecuperada);
                    return;
                default:
                    System.out.println("Essa ação não está disponível, tente novamente...");
            }
        }
    }

    public static void turnoDoInimigo(Inimigo inimigo, Personagem jogador) {
        int dano = inimigo.atacar(jogador);
        System.out.printf("[TURNO DO INIMIGO]\n%s atacou %s! (DMG: %d)\n",
                inimigo.getNome(), jogador.getNome(), dano);
    }

    public static void fimDeJogo(Personagem jogador, Inimigo oponente) {
        System.out.printf("%s VENCEU!\n", jogador.estaVivo() ? jogador.getNome() : oponente.getNome());
    }
}
