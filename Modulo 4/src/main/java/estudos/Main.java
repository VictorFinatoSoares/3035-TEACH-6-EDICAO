package estudos;

public class Main {
    public static void main(String[] args) {
        Jogador jogadorUm = new Jogador(Posicao.ATACANTE.getDescricao(), "Neymar", 31, "Preto", 1.76);

        System.out.println(jogadorUm.getPosicao());
        System.out.println(jogadorUm.getAltura());
        System.out.println(jogadorUm.getCorDeCabelo());
        System.out.println(jogadorUm.getNome());
        System.out.println(jogadorUm.getIdade());

        jogadorUm.setPosicao(Posicao.ZAGUEIRO.getDescricao());
        jogadorUm.setIdade(32);

        jogadorUm.chutarBola();

        System.out.println(jogadorUm.getPosicao());
        System.out.println(jogadorUm.getIdade());

    }
}
