package desafio;

public class CriadorPersonagem {
    private static final int VIDA_INICIAL = 100;
    private static final int ATAQUE_INICIAL = 15;
    private static final int DEFESA_INICIAL = 6;
    private static final int POCOES_INICIAS = 3;

    public static Personagem criarJogador() {
        String nome = Input.lerLinha("Digite o seu nome: ");
        int classe;

        while (true) {
            System.out.print("""
                    [LISTA DE CLASSES]
                    \s
                    [1] Guerreiro (BÔNUS: +15 Vida)
                    [2] Mago (BÔNUS: +2 Ataque)
                    [3] Arqueiro (BÔNUS: +1 Defesa)
                    \s
                    """);

            classe = Input.lerInteiro("Sua escolha (1-3): ");

            // Verifica se a classe está nas opções
            if (classe < 1 || classe > 3) {
                System.out.println("ERRO: Essa classe não existe!");
                continue;
            }
            break;
        }

        Personagem jogador;

        // As estatísticas base de cada classe são as mesmas
        if (classe == 1) {
            jogador = new Guerreiro(nome, VIDA_INICIAL, ATAQUE_INICIAL, DEFESA_INICIAL);
            System.out.println("Você escolheu: Guerreiro");
        } else if (classe == 2) {
            jogador = new Mago(nome, VIDA_INICIAL, ATAQUE_INICIAL, DEFESA_INICIAL);
            System.out.println("Você escolheu: Mago");
        } else {
            jogador = new Arqueiro(nome, VIDA_INICIAL, ATAQUE_INICIAL, DEFESA_INICIAL);
            System.out.println("Você escolheu: Arqueiro");
        }

        // Retorna o jogador com a classe escolhida e 3 poções no inventário (quantidade padrão)
        jogador.adicionarPocaoCura(POCOES_INICIAS);
        return jogador;
    }

    public static Inimigo criarOponente() {
        return new Inimigo();
    }
}
