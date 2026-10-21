package desafio;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Inimigo extends Personagem {
    private static final Random RANDOM = new Random();
    private static final List<String> LISTA_NOMES = Arrays.asList(
            "Malakar, o Devorador de Sombras",
            "Vorgath, o Senhor da Guerra",
            "Lyra, a Bruxa do Pantâno",
            "KAZAR, o Autômato de Aço",
            "Corvax, o Nobre Traidor");

    public Inimigo() {
        super(LISTA_NOMES.get(RANDOM.nextInt(LISTA_NOMES.size())),
                RANDOM.nextInt(50, 100),
                RANDOM.nextInt(10, 20),
                RANDOM.nextInt(2, 8));
    }
}
