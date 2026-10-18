package desafio;

import java.util.List;

public class Mago extends Personagem {
    private static final int BONUS_ATAQUE = 10;
    private List<String> inventario;

    public Mago(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque + BONUS_ATAQUE, defesa);
    }
}
