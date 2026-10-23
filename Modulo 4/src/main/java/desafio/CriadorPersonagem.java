package desafio;

public class CriadorPersonagem {
    public static Personagem criarJogador() {
        String nome = Input.lerLinha("Digite o seu nome: ");
        int classe;

        while (true) {
            System.out.print("""
                    [LISTA DE CLASSES]
                    \s
                    [1] Guerreiro (BÔNUS: +5 Vida)
                    [2] Mago (BÔNUS: +5 Ataque)
                    [3] Arqueiro (BÔNUS: +5 Defesa)
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

        if (classe == 1) {
            jogador = new Guerreiro(nome, 100, 16, 6);
            System.out.println("Você escolheu: Guerreiro");
        } else if (classe == 2) {
            jogador = new Mago(nome, 100, 16, 6);
            System.out.println("Você escolheu: Mago");
        } else {
            jogador = new Arqueiro(nome, 100, 16, 6);
            System.out.println("Você escolheu: Arqueiro");
        }

        // Retorna o jogador com a classe escolhida e 3 poções no inventário (quantidade padrão)
        jogador.adicionarPocaoCura(3);
        return jogador;
    }

    public static Inimigo criarOponente() {
        return new Inimigo();
    }
}
