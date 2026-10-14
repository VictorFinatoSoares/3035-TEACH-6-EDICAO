package exercicios.collections;

import java.util.ArrayList;
import java.util.HashSet;

public class Ex03 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(5);

        set.add(5);
        set.add(4);
        set.add(3);
        set.add(1);
        set.add(2);

        // O hashset ordena automaticamente os números
        list.forEach(item -> System.out.println(item));
        set.forEach(item -> System.out.println(item));
    }
}
