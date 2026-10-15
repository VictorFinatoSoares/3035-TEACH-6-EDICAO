package exercicios.lambda;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Ex02 {
    public static void main(String[] args) {
        int numero = 2;

        IntPredicate isPrimo = n -> n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
        boolean resultado = isPrimo.test(numero);

        System.out.println("O número " + numero + " é primo? " + resultado);
    }
}
