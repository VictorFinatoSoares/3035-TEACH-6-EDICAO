package desafio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jogo {
    private static final int TOTAL_INIMIGOS = 3;
    private static final int PONTOS_POR_VITORIA = 10;
    private static final Map<String, Integer> ranking = new HashMap<>();

    public static void main(String[] args) {
        do {
            iniciarJogo();
        } while (continuarJogando());

        System.out.println("Encerrando arena... Até logo!");
    }

    public static void iniciarJogo() {
        System.out.println("Bem-vindo à Arena dos Campeões!");

        Personagem jogador = CriadorPersonagem.criarJogador();
        int qtdVitorias = 0;
        int pontuacao = 0;

        // O jogo termina se o jogador morrer ou vencer os três oponentes
        while (jogador.estaVivo() && qtdVitorias < TOTAL_INIMIGOS) {
            Inimigo oponente = CriadorPersonagem.criarOponente();

            // A vida e as poções continuam entre as batalhas, mas a defesa é zerada
            Batalha.iniciarBatalha(jogador, oponente);

            if (!oponente.estaVivo()) {
                qtdVitorias++;
                pontuacao += PONTOS_POR_VITORIA;
                System.out.printf("%s foi derrotado!\n[PLACAR %d/%d]\n",
                        oponente.getNome(), qtdVitorias, TOTAL_INIMIGOS);
                System.out.printf("+%d pontos!\n", PONTOS_POR_VITORIA);
            }

            if (!jogador.estaVivo()) {
                System.out.println("\nOps...");
                Batalha.exibirStatus(jogador, oponente);
            }
        }

        ranking.merge(jogador.getNome(), pontuacao, Integer::sum);
        fimDeJogo(qtdVitorias, TOTAL_INIMIGOS, pontuacao);

        exibirRanking(ranking);
    }

    public static void exibirRanking(Map<String, Integer> pontuacoesPorJogador) {
        System.out.println("\n[RANKING DE PONTUAÇÕES]\n");

        // Copia as entradas do mapa para uma lista que pode ser ordenada, sem alterar o mapa
        List<Map.Entry<String, Integer>> rankingOrdenado = new ArrayList<>(pontuacoesPorJogador.entrySet());
        // A lista é ordenada por pontuação, da maior para a menor
        rankingOrdenado.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        // Variável para controlar a posição no ranking
        int posicao = 1;

        // For percorre a lista já ordenada
        for (Map.Entry<String, Integer> entry : rankingOrdenado) {
            String nomeJogador = entry.getKey();
            Integer pontuacaoJogador = entry.getValue();

            System.out.printf("%dº Lugar - Jogador: %s | Pontos: %d\n",
                    posicao, nomeJogador, pontuacaoJogador);

            posicao++;
        }
    }

    public static boolean continuarJogando() {
        while (true) {
            String resposta = Input.lerLinha("Deseja continuar jogando (S/N)? ");

            if (resposta.length() != 1 || (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N"))) {
                System.out.println("ERRO: Você precisa digitar S (Sim) ou N (Não)!");
                continue;
            }

            return resposta.equalsIgnoreCase("S");
        }
    }

    public static void fimDeJogo(int qtdVitorias, int totalInimigos, int pontuacao) {
        System.out.println(qtdVitorias == totalInimigos ?
                "Você venceu! Campeão da arena!" : "Você perdeu! Talvez em uma próxima partida!");
        System.out.printf("Sua pontuação nesta partida foi: %d\n", pontuacao);
    }
}
