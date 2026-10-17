package desafio;

import java.util.List;

public class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected List<String> inventario;

    public Personagem(String nome, int vida, int ataque, int defesa, List<String> inventario) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.inventario = inventario;
    }

    public void atacar(Personagem alvo) {
        System.out.println("ATACOU");
    }

    public void defender() {
        System.out.println("DEFENDOU");
    }

    public void receberDano(int dano) {
        System.out.println("RECEBEU DANO");
    }

    public boolean estaVivo() {
        return true;
    }
}
