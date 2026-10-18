package desafio;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Inimigo extends Personagem {
    private static final Random RANDOM = new Random();
    private static final List<String> LISTA_NOMES = Arrays.asList("Malakar, o Devorador de Sombras",
            "Vorgath, o Senhor da Guerra",
            "Lyra, a Bruxa do Pantâno",
            "KAZAR, o Autômato de Aço",
            "Corvax, o Nobre Traidor");

    public Inimigo() {
        // Gera um índice aleatório para buscar na lista de nomes para definir o nome do inimigo aleatoriamente
        String nome = LISTA_NOMES.get(RANDOM.nextInt(LISTA_NOMES.size()));

        int vida = RANDOM.nextInt(50, 100);
        int ataque = RANDOM.nextInt(10, 20);
        int defesa = RANDOM.nextInt(2, 8);

        super(nome, vida, ataque, defesa);
    }
}
