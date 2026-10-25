package desafio;

public class Batalha {
    public static void iniciarBatalha(Personagem jogador, Inimigo oponente) {
        // As defesas não são mantidas entre batalhas diferentes
        jogador.limparDefesa();
        oponente.limparDefesa();

        System.out.printf("Inimigo encontrado: %s!\n", oponente.getNome());
        exibirStatus(jogador, oponente);

        while (jogador.estaVivo() && oponente.estaVivo()) {
            // O inimigo só age se ainda estiver vivo após a ação do jogador
            turnoDoJogador(jogador, oponente);
            exibirStatus(jogador, oponente);

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
                    int dano = jogador.atacar(oponente);
                    System.out.printf("%s ataca %s! (Causou %d de dano)\n", jogador.getNome(), oponente.getNome(), dano);
                    return;
                case 2:
                    jogador.defender();
                    System.out.printf("%s se defende. O próximo dano recebido será reduzido pela metade.\n", jogador.getNome());
                    return;
                case 3:
                    int vidaRecuperada = jogador.usarPocaoCura();
                    if (vidaRecuperada == 0) {
                        // Cura inválida não encerra o turno: o jogador pode escolher outra ação.
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
        if (Inimigo.deveDefender()) {
            inimigo.defender();
            System.out.printf("[TURNO DO INIMIGO]\n%s se defende! O próximo dano recebido será reduzido pela metade.\n", inimigo.getNome());
        } else {
            int dano = inimigo.atacar(jogador);
            System.out.printf("[TURNO DO INIMIGO]\n%s atacou %s! (Causou %d de dano)\n", inimigo.getNome(), jogador.getNome(), dano);
        }
    }
}
