package desafio;

public class Guerreiro extends Personagem {
    private static final int BONUS_VIDA = 10;

    public Guerreiro(String nome, int vida, int ataque, int defesaBase) {
        super(nome, vida + BONUS_VIDA, ataque, defesaBase);
    }
}
