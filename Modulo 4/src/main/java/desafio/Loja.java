package desafio;

public class Loja {
    private static final int CUSTO_MELHORIA = 10;
    private static final int BONUS_ATAQUE = 2;
    private static final int BONUS_VIDA = 15;

    // Exibe as opções, aplica no máximo uma melhoria e devolve o saldo atualizado
    public static int abrirLoja(Personagem jogador, int moedas) {
        System.out.printf("""

                [LOJA ENTRE BATALHAS]
                Você tem %d moedas.

                [1] Melhorar ataque em %d (custa %d moedas)
                [2] Melhorar vida máxima em %d (custa %d moedas)
                [0] Sair da loja

                """, moedas, BONUS_ATAQUE, CUSTO_MELHORIA, BONUS_VIDA, CUSTO_MELHORIA);

        if (moedas < CUSTO_MELHORIA) {
            System.out.println("Você não tem moedas suficientes.");
            return moedas;
        }

        int escolha = Input.lerInteiro("Escolha uma opção (0-2): ");

        switch (escolha) {
            case 1:
                jogador.melhorarAtaque(BONUS_ATAQUE);
                moedas -= CUSTO_MELHORIA;
                System.out.println("Ataque melhorado!");
                return moedas;
            case 2:
                // A melhoria aumenta a vida máxima e recupera a mesma quantidade de vida
                jogador.melhorarVidaMaxima(BONUS_VIDA);
                moedas -= CUSTO_MELHORIA;
                System.out.println("Vida máxima aumentada!");
                return moedas;
            case 0:
                System.out.println("Você saiu da loja.");
                return moedas;
            default:
                System.out.println("Essa opção não existe. Você seguirá sem comprar.");
                return moedas;
        }
    }
}
