package exercicios.collections;

import java.util.ArrayList;
import java.util.HashSet;

public class Ex04 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("Mesa");
        list.add("Suporte");
        list.add("Suporte");
        list.add("Espelho");
        list.add("Papelaria");
        list.add("Papel");
        list.add("Papel");

        HashSet<String> set = new HashSet(list);

        System.out.println("====== ARRAYLIST -> HASHSET ======");
        set.forEach(item -> System.out.println(item));

        ArrayList<String> list2 = new ArrayList(set);

        System.out.println("====== HASHSET -> ARRAYLIST ======");
        list2.forEach(item -> System.out.println(item));

    }
}
