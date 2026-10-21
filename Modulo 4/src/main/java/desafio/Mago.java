package desafio;

public class Mago extends Personagem {
    private static final int BONUS_ATAQUE = 10;

    public Mago(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque + BONUS_ATAQUE, defesa);
    }
}
