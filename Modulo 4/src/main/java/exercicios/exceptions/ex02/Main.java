package exercicios.exceptions.ex02;

public class Main {
    public static void main(String[] args) {
        try {
            String vazio = null;
            int num = Integer.parseInt(vazio.trim());
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("ERRO: É necessário usar um número no parseInt().");
        } catch (NullPointerException e) {
            System.out.println("A String passada não pode ser nula.");
        }
    }
}
