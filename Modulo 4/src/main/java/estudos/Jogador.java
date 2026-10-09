package estudos;

public class Jogador {
    private String posicao;
    private String nome;
    private int idade;
    private String corDeCabelo;
    private double altura;

    public Jogador(String posicao, String nome, int idade, String corDeCabelo, double altura) {
        this.posicao = posicao;
        this.nome = nome;
        this.idade = idade;
        this.corDeCabelo = corDeCabelo;
        this.altura = altura;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCorDeCabelo() {
        return corDeCabelo;
    }

    public void setCorDeCabelo(String corDeCabelo) {
        this.corDeCabelo = corDeCabelo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
