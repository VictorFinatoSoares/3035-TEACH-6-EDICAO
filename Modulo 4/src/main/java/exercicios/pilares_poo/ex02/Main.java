package exercicios.pilares_poo.ex02;

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Zoreia", "AU-AU");
        Gato gato = new Gato("Misty", "Miau");

        cachorro.fazerSom();
        gato.fazerSom();
    }
}
