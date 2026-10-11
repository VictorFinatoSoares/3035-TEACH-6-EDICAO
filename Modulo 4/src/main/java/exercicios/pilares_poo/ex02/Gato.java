package exercicios.pilares_poo.ex02;

public class Gato extends Animal {
    public Gato(String nome, String som) {
        super(nome, som);
    }

    public void fazerSom() {
        System.out.printf("%s: %s\n", this.nome, this.som);
    }
}
