package desafio;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Inimigo extends Personagem {
    private static final Random RANDOM = new Random();

    // O limite final não entra no sorteio, 91 permite sortear até 90
    private static final int VIDA_MINIMA = 75;
    private static final int VIDA_MAXIMA = 91;

    private static final int DANO_MINIMO = 12;
    private static final int DANO_MAXIMO = 17;

    private static final int DEFESA_MINIMA = 1;
    private static final int DEFESA_MAXIMA = 4;

    private static final List<String> LISTA_NOMES = Arrays.asList(
            "Malakar, o Devorador de Sombras",
            "Vorgath, o Senhor da Guerra",
            "Lyra, a Bruxa do Pântano",
            "KAZAR, o Autômato de Aço",
            "Corvax, o Nobre Traidor");

    public Inimigo() {
        // Gera atributos aleatórios para o inimigo
        super(LISTA_NOMES.get(RANDOM.nextInt(LISTA_NOMES.size())), // Índice na lista de nomes (0-4)
                RANDOM.nextInt(VIDA_MINIMA, VIDA_MAXIMA), // Vida (75-90)
                RANDOM.nextInt(DANO_MINIMO, DANO_MAXIMO), // Dano (12-16)
                RANDOM.nextInt(DEFESA_MINIMA, DEFESA_MAXIMA)); // Defesa (1-3)
    }

    public static boolean deveDefender() {
        // 25% de chance do inimigo decidir defender em um turno
        return RANDOM.nextInt(4) == 0;
    }
}
