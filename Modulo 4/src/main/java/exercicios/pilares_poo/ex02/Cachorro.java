package exercicios.pilares_poo.ex02;

public class Cachorro extends Animal {
    public Cachorro(String nome, String som) {
        super(nome, som);
    }

    public void fazerSom() {
        System.out.printf("%s: %s\n", this.nome, this.som);
    }
}
