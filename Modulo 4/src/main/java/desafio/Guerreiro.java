package desafio;

import java.util.List;

public class Guerreiro extends Personagem {
    private static final int BONUS_VIDA = 10;
    private List<String> inventario;

    public Guerreiro(String nome, int vida, int ataque, int defesa) {
        super(nome, vida + BONUS_VIDA, ataque, defesa);
    }
}
