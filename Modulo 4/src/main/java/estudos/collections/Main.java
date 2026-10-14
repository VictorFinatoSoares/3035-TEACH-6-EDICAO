package estudos.collections;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Victor");
        list.add("Victor");
        list.forEach(item -> System.out.println(item));


        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Finato");
        hashSet.add("Finato");

        hashSet.forEach(item -> System.out.println(item));

    }
}
