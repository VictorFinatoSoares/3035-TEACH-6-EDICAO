package estudos.exceptions;

public class Main {
    public static void main(String[] args) {
        int numeroInt = 0;

        try {
            numeroInt = Integer.parseInt("5");
            numeroInt /= 0;
        } catch (NumberFormatException e) {
            System.out.println("ERRO: Você precisa usar um número INTEIRO na String para realizar o parse. ");
        } catch (ArithmeticException e) {
            System.out.println("ERRO: Você não pode dividir um número por ZERO. ");
        } finally {
            System.out.printf("Número: %d\n", numeroInt);
        }
        System.out.printf("Número: %d", numeroInt);
    }
}
