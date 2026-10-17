package desafio;

import java.util.List;

public class Arqueiro extends Personagem {
    private int bonusDefesa;

    public Arqueiro(String nome, int vida, int ataque, int defesa, List<String> inventario, int bonusDefesa) {
        super(nome, vida, ataque, defesa, inventario);
        this.bonusDefesa = bonusDefesa;
    }
}
