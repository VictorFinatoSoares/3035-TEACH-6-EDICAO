package desafio;

public class Arqueiro extends Personagem {
    private static final int BONUS_DEFESA = 1;

    public Arqueiro(String nome, int vida, int ataque, int defesaBase) {
        // O bônus de defesa reduz o dano que o arqueiro recebe
        super(nome, vida, ataque, defesaBase + BONUS_DEFESA);
    }
}
