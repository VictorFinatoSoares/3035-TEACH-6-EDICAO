package desafio;

import java.util.Arrays;
import java.util.List;

public class Inimigo extends Personagem {
    private final List<String> listaNomes = Arrays.asList("Malakar, o Devorador de Sombras", "Vorgath, o Senhor da Guerra", "Lyra, a Bruxa do Pantâno", "KAZAR, o Autômato de Aço", "Corvax, o Nobre Traidor");

    public Inimigo(String nome, int vida, int ataque, int defesa, List<String> inventario) {
        super(nome, vida, ataque, defesa, inventario);
    }
}
