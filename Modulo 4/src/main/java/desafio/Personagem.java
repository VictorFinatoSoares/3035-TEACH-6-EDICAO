package desafio;

public class Personagem {
    private static final String POCAO_CURA = "Poção de Cura";
    private static final int PONTOS_CURA = 20;
    private final String nome;
    private int vida;
    private final int ataque;
    private final int defesaBase;
    private final Inventario inventario = new Inventario();
    private final int vidaMaxima;
    private boolean estaDefendendo;

    // Guarda os atributos comuns a qualquer personagem e a vida máxima usada pela cura
    public Personagem(String nome, int vida, int ataque, int defesaBase) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.ataque = ataque;
        this.defesaBase = defesaBase;
    }

    public int atacar(Personagem alvo) {
        return alvo.tomarDano(ataque);
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void defender() {
        // A defesa fica ativa até o personagem receber o próximo ataque
        estaDefendendo = true;
    }

    public void limparDefesa() {
        estaDefendendo = false;
    }

    public int tomarDano(int dano) {
        // Aplica a defesa base
        int danoFinal = Math.max(0, dano - defesaBase);

        // Se estiver defendendo, reduz o próximo dano pela metade e consome a defesa
        if (estaDefendendo) {
            danoFinal /= 2;
            limparDefesa();
        }

        // A vida não fica negativa, o valor retornado é o dano calculado após as defesas
        this.vida = Math.max(0, this.vida - danoFinal);
        return danoFinal;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public int usarPocaoCura() {
        // Não consome poção se o personagem já estiver com a vida cheia ou sem itens
        if (!podeCurar()) {
            return 0;
        }

        int vidaAntes = vida;

        // Consome a poção e recupera até 20 pontos, sem ultrapassar a vida máxima
        inventario.remover(POCAO_CURA);
        vida = Math.min(vida + PONTOS_CURA, vidaMaxima);

        return vida - vidaAntes;
    }

    public boolean podeCurar() {
        return vida < vidaMaxima && contarPocoesCura() != 0;
    }

    public void adicionarPocaoCura(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            inventario.adicionar(POCAO_CURA);
        }
    }

    public int contarPocoesCura() {
        return inventario.contar(POCAO_CURA);
    }
}
