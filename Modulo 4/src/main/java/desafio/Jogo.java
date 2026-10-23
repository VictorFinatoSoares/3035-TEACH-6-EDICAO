package desafio;

public class Jogo {
    private static final int TOTAL_INIMIGOS = 3;
    public static void main(String[] args) {
        iniciarJogo();
    }

    public static void iniciarJogo() {
        System.out.println("Bem vindo à Arena dos Campeões!");

        Personagem jogador = CriadorPersonagem.criarJogador();
        int qtdVitorias = 0;

        while (jogador.estaVivo() && qtdVitorias < TOTAL_INIMIGOS) {
            Inimigo oponente = CriadorPersonagem.criarOponente();

            // A vida e as poções são mantidas entre as batalhas.
            Batalha.iniciarBatalha(jogador, oponente);

            if (!oponente.estaVivo()) {
                qtdVitorias++;
                System.out.printf("%s foi derrotado!\nPlacar: %d/%d\n", oponente.getNome(), qtdVitorias, TOTAL_INIMIGOS);
            }

            if (!jogador.estaVivo()) {
                System.out.println("Ops...");
                Batalha.exibirStatus(jogador, oponente);
            }
        }

        fimDeJogo(qtdVitorias, TOTAL_INIMIGOS);
    }

    public static void fimDeJogo(int qtdVitorias, int totalInimigos) {
        System.out.println(qtdVitorias == totalInimigos ? "Você VENCEU! Campeão da arena!" : "Você PERDEU! Talvez em uma próxima partida!");
    }
}
