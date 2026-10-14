package exercicios.collections;

import java.util.ArrayList;
import java.util.HashSet;

public class Ex05 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 10; i >= 0; i--) {
            list.add(i);
        }

        list.removeIf(i -> i % 2 == 0);

        HashSet<Integer> set = new HashSet<>(list);

        set.forEach(item -> System.out.println(item));

    }
}
