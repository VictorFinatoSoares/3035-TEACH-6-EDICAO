package desafio;

public class Guerreiro extends Personagem {
    private static final int BONUS_VIDA = 15;

    public Guerreiro(String nome, int vida, int ataque, int defesaBase) {
        // O guerreiro recebe mais vida inicial, mantendo os demais atributos base
        super(nome, vida + BONUS_VIDA, ataque, defesaBase);
    }
}
