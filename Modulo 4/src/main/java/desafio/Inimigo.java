package desafio;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Inimigo extends Personagem {
    private static final Random RANDOM = new Random();
    // Nomes possíveis para o inimigo
    private static final List<String> LISTA_NOMES = Arrays.asList(
            "Malakar, o Devorador de Sombras",
            "Vorgath, o Senhor da Guerra",
            "Lyra, a Bruxa do Pântano",
            "KAZAR, o Autômato de Aço",
            "Corvax, o Nobre Traidor");

    public static boolean deveDefender() {
        // Em 1 de 4 resultados o inimigo defende; nos outros 3, ataca.
        return RANDOM.nextInt(4) == 0;
    }

    public Inimigo() {
        // Gera estatísticas aleatórias pro inimigo
        super(LISTA_NOMES.get(RANDOM.nextInt(LISTA_NOMES.size())),
                RANDOM.nextInt(70, 90),
                RANDOM.nextInt(15, 21),
                RANDOM.nextInt(2, 6));
    }
}
