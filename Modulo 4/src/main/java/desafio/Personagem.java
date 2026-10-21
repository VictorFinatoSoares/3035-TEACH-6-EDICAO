package desafio;

import java.util.ArrayList;
import java.util.List;

public class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected List<String> inventario = new ArrayList<>();
    private final int vidaMaxima;
    private boolean defendendo;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public int atacar(Personagem alvo) {
        return alvo.receberDano(ataque);
    }

    public void defender() {
        defendendo = true;
    }

    public String podeCurar() {
        if (vida >= vidaMaxima) {
            return "Sua vida já está cheia.";
        }
        if (!inventario.contains("Poção de Cura")) {
            return "Você não tem poções de cura.";
        }

        return "";
    }

    public int usarPocaoCura() {
        if (!podeCurar().isEmpty()) {
            return 0;
        }

        int vidaAntes = vida;
        inventario.remove("Poção de Cura");
        vida = Math.min(vida + 20, vidaMaxima);

        return vida - vidaAntes;
    }

    public int receberDano(int dano) {
        int danoFinal = Math.max(0, dano - defesa);

        if (defendendo) {
            danoFinal /= 2;
            defendendo = false;
        }

        this.vida = Math.max(0, this.vida - danoFinal);
        return danoFinal;
    }

    public boolean estaVivo() {
        return Math.max(0, this.vida) > 0;
    }

    public void adicionarItem(String item) {
        inventario.add(item);
    }

    public int contarItem(String item) {
        return (int) inventario.stream().filter(item::equals).count();
    }
}
