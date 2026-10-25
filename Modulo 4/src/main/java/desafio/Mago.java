package desafio;

public class Mago extends Personagem {
    private static final int BONUS_ATAQUE = 2;

    public Mago(String nome, int vida, int ataque, int defesaBase) {
        // O mago causa mais dano por ataque, mantendo vida e defesa base
        super(nome, vida, ataque + BONUS_ATAQUE, defesaBase);
    }
}
