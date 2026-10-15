package exercicios.lambda;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbersList = numbersList.stream().filter(num -> num % 2 == 0).toList();
        evenNumbersList.forEach(System.out::println);
    }
}
