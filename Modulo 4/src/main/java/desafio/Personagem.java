package desafio;

import java.util.List;

public class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public int atacar(Personagem alvo) {
        return alvo.receberDano(ataque);
    }

    public void defender() {
        System.out.println("DEFENDEU");
    }

    public int receberDano(int dano) {
        int danoFinal = Math.max(0, dano - defesa);
        this.vida = Math.max(0, this.vida - danoFinal);
        return danoFinal;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }
}
