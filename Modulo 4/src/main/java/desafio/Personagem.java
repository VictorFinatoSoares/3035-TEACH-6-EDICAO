package desafio;

import java.util.ArrayList;
import java.util.List;

public class Personagem {
    private final String nome;
    private int vida;
    private final int ataque;
    private final int defesa;
    private final List<String> inventario = new ArrayList<>();
    private final int vidaMaxima;
    private boolean estaDefendendo;

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

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void defender() {
        estaDefendendo = true;
    }

    public String mensagemErroCura() {
        if (vida >= vidaMaxima) {
            return "Sua vida já está cheia.";
        }

        if (!inventario.contains("Poção de Cura")) {
            return "Você não tem poções de cura.";
        }

        // String vazia indica que a cura pode ser usada.
        return "";
    }

    public int usarPocaoCura() {
        // Bloqueia a cura se a vida estiver cheia ou não houver poções.
        if (!mensagemErroCura().isEmpty()) {
            return 0;
        }

        int vidaAntes = vida;

        // Consome uma poção e recupera até 20 HP.
        inventario.remove("Poção de Cura");
        vida = Math.min(vida + 20, vidaMaxima);

        return vida - vidaAntes;
    }

    public int receberDano(int dano) {
        int danoFinal = Math.max(0, dano - defesa);

        if (estaDefendendo) { // Reduz o próximo dano pela metade e consome a defesa.
            danoFinal /= 2;
            estaDefendendo = false;
        }

        // Aplica o dano final à vida e retorna seu valor.
        this.vida = Math.max(0, this.vida - danoFinal);
        return danoFinal;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void adicionarItem(String item) {
        inventario.add(item);
    }

    public int contarItem(String item) {
        // Conta as ocorrências do item no inventário.
        return (int) inventario.stream().filter(item::equals).count();
    }
}
