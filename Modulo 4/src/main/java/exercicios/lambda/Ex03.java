package exercicios.lambda;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.List;

public class Ex03 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("abacaxi", "melancia", "carambola", "repolho", "cenoura");

        UnaryOperator<List<String>> palavrasMaiusculas = lista -> lista.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(palavrasMaiusculas.apply(palavras));
    }
}
