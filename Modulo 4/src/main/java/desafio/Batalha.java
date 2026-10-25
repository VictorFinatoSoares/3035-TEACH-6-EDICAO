package desafio;

public class Batalha {
    public static void iniciarBatalha(Personagem jogador, Inimigo oponente) {
        // As defesas não são mantidas entre batalhas diferentes
        jogador.limparDefesa();
        oponente.limparDefesa();

        System.out.printf("Inimigo encontrado: %s!\n", oponente.getNome());
        exibirStatus(jogador, oponente);

        while (jogador.estaVivo() && oponente.estaVivo()) {
            turnoDoJogador(jogador, oponente);
            exibirStatus(jogador, oponente);

            // O inimigo só age se ainda estiver vivo após a ação do jogador
            if (oponente.estaVivo()) {
                turnoDoInimigo(oponente, jogador);
                if (jogador.estaVivo()) {
                    exibirStatus(jogador, oponente);
                }
            }
        }
    }

    public static void exibirStatus(Personagem jogador, Inimigo oponente) {
        System.out.printf("""
                \s
                [SITUAÇÃO DA BATALHA ATUAL]
                %s (%d de vida)
                %s (%d de vida)
                \s
                """, jogador.getNome(), jogador.getVida(), oponente.getNome(), oponente.getVida());
    }

    public static void turnoDoJogador(Personagem jogador, Inimigo oponente) {
        while (true) {
            System.out.printf("""
                    \s
                    [TURNO DO JOGADOR]
                    \s
                    Ações disponíveis:
                    \s
                    [1] Atacar
                    [2] Defender (Reduz o dano do próximo ataque pela metade)
                    [3] Usar poção de cura (%d restantes)
                    \s
                    """, jogador.contarPocoesCura());

            int acao = Input.lerInteiro("Escolha sua ação (1-3): ");

            switch (acao) {
                case 1:
                    // O método atacar retorna o dano causado ao alvo
                    int dano = jogador.atacar(oponente);
                    System.out.printf("%s ataca %s! (Causou %d de dano)\n", jogador.getNome(), oponente.getNome(), dano);
                    return;
                case 2:
                    // A defesa reduz o dano do próximo ataque pela metade (considera a defesa base do jogador também)
                    jogador.defender();
                    System.out.printf("%s se defende. O próximo dano recebido será reduzido pela metade.\n", jogador.getNome());
                    return;
                case 3:
                    int vidaRecuperada = jogador.usarPocaoCura();

                    // Se a cura não foi possível, ainda é possível escolher uma ação nesse turno
                    if (vidaRecuperada == 0) {
                        System.out.println("Não foi possível se curar!");
                        continue;
                    }

                    System.out.printf("%s se curou! (Ganhou %d pontos de vida)\n", jogador.getNome(), vidaRecuperada);
                    return;
                default:
                    System.out.println("Essa ação não está disponível, tente novamente...");
            }
        }
    }

    public static void turnoDoInimigo(Inimigo inimigo, Personagem jogador) {
        System.out.println("[TURNO DO INIMIGO]");

        if (Inimigo.deveDefender()) {
            inimigo.defender();
            System.out.printf("%s se defende! O próximo dano recebido será reduzido pela metade.\n", inimigo.getNome());
        } else {
            int dano = inimigo.atacar(jogador);
            System.out.printf("%s atacou %s! (Causou %d de dano)\n", inimigo.getNome(), jogador.getNome(), dano);
        }
    }
}
