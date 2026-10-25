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
        // 25% de chance do inimigo decidir defender em um turno
        return RANDOM.nextInt(4) == 0;
    }

    public Inimigo() {
        // Gera atributos aleatórios para o inimigo
        super(LISTA_NOMES.get(RANDOM.nextInt(LISTA_NOMES.size())), // Índice na lista de nomes (0-4)
                RANDOM.nextInt(75, 91), // Vida (75-90
                RANDOM.nextInt(12, 17), // Dano (12-16)
                RANDOM.nextInt(1, 4)); // Defesa (1-3)
    }
}
