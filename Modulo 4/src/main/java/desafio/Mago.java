package desafio;

public class Mago extends Personagem {
    private static final int BONUS_ATAQUE = 5;

    public Mago(String nome, int vida, int ataque, int defesaBase) {
        super(nome, vida, ataque + BONUS_ATAQUE, defesaBase);
    }
}
