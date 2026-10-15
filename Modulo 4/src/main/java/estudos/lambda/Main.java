
package estudos.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("12", "62", "25", "22", "03", "22");
        String test = "22";

        Comparator<String> comparator = String::compareTo;
        Predicate<String> predicate = p1 -> p1.equalsIgnoreCase(test);
        Consumer<String> consumer = item -> System.out.println(item);

        System.out.println("=========================================================");
        System.out.println("Ordenada pelo comparator e usando o consumer para printar");
        list.stream()
                .sorted(comparator)
                .forEach(consumer);

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("Filtrando pelo predicate e usando o consumer para printar");
        list.stream()
                .filter(predicate)
                .distinct()
                .forEach(consumer);

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("Usando o consumer para printar e sem ordenar");
        list.stream()
                .forEach(consumer);

    }
}