package desafio;

import java.util.List;

public class Guerreiro extends Personagem {
    private int bonusVida;

    public Guerreiro(String nome, int vida, int ataque, int defesa, List<String> inventario, int bonusVida) {
        super(nome, vida, ataque, defesa, inventario);
        this.bonusVida = bonusVida;
    }
}
