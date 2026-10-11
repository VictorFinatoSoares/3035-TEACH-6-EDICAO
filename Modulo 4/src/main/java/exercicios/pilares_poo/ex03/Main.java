package exercicios.pilares_poo.ex03;

public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(10.5);
        Retangulo retangulo = new Retangulo(23.4, 17.6);

        System.out.printf("Área do círculo: %.2f\n", circulo.calcularArea());
        System.out.printf("Área do retângulo: %.2f\n", retangulo.calcularArea());
    }
}
