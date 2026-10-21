package desafio;

public class Arqueiro extends Personagem {
    private static final int BONUS_DEFESA = 10;

    public Arqueiro(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa + BONUS_DEFESA);
    }
}
