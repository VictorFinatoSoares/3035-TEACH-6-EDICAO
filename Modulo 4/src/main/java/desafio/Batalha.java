package desafio;

public class Batalha {
    public static void iniciarBatalha(Personagem jogador, Inimigo oponente) {
        exibirStatus(jogador, oponente);

        while (jogador.estaVivo() && oponente.estaVivo()) {
            Batalha.turnoDoJogador(jogador, oponente);
            Batalha.exibirStatus(jogador, oponente);

            if (oponente.estaVivo()) {
                Batalha.turnoDoInimigo(oponente, jogador);
                Batalha.exibirStatus(jogador, oponente);
            }
        }
    }

    public static void exibirStatus(Personagem jogador, Inimigo oponente) {
        System.out.printf("""
                \s
                ==== SITUAÇÃO DE BATALHA ====:
                %s (%d HP) vs %s (%d HP)
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
                    """, jogador.contarPocoesCura());

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
                    int vidaRecuperada = jogador.usarPocaoCura();
                    if (vidaRecuperada == 0) {
                        continue;
                    }

                    System.out.printf("%s se curou! (+%d HP)\n", jogador.getNome(), vidaRecuperada);
                    return;
                default:
                    System.out.println("Essa ação não está disponível, tente novamente...");
            }
        }
    }

    public static void turnoDoInimigo(Inimigo inimigo, Personagem jogador) {
        int dano = inimigo.atacar(jogador);
        System.out.printf("[TURNO DO INIMIGO]\n%s atacou %s! (DMG: %d)\n", inimigo.getNome(), jogador.getNome(), dano);
    }
}
