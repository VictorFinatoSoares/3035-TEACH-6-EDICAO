package desafio;

import java.util.List;

public class Mago extends Personagem {
    private int bonusDano;

    public Mago(String nome, int vida, int ataque, int defesa, List<String> inventario, int bonusDano) {
        super(nome, vida, ataque, defesa, inventario);
        this.bonusDano = bonusDano;
    }
}
