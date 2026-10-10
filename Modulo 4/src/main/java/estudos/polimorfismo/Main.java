package estudos.polimorfismo;

public class Main {
    public static void main(String[] args) {
        Brinquedo aviao = new Aviao();
        Brinquedo barco = new Barco();

        System.out.print("Avião: ");
        aviao.mover();

        System.out.print("Barco: ");
        barco.mover();
    }
}
