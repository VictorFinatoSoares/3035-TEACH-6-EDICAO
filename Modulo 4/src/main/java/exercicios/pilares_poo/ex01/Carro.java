package exercicios.pilares_poo.ex01;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getDescricao() {
        return String.format("Marca: %s, Modelo: %s, Ano: %d", this.marca, this.modelo, this.ano);
    }
}
