package estudos;

public enum Posicao {
    ATACANTE("Atacante"),
    ZAGUEIRO("Zagueiro"),
    GOLEIRO("Goleiro");

    private String descricao;

    Posicao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
