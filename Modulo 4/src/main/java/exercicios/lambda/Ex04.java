package exercicios.lambda;

import java.util.Arrays;
import java.util.List;

public class Ex04 {
    public static void main(String[] args ) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int somaNumeros = numeros.stream().mapToInt(x -> x).sum();
        System.out.println(somaNumeros);
    }
}
