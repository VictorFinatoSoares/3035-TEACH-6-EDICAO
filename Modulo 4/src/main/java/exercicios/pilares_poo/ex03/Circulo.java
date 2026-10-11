package exercicios.pilares_poo.ex03;

public class Circulo implements Forma {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.pow(this.raio, 2) * Math.PI;
    }
}
