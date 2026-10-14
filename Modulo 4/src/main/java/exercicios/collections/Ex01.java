package exercicios.collections;

import java.util.ArrayList;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList<>();

        frutas.add("Morango");
        frutas.add("Melancia");
        frutas.add("Banana");
        frutas.add("Maracujá");
        frutas.add("Laranja");

        System.out.println(frutas.size());
        System.out.println(frutas.get(2));

        frutas.removeFirst();

        System.out.println(frutas.contains("Cereja") ? "Cereja está no arraylist!" : "Cereja não está no arraylist!");
        frutas.add("Cereja");

        frutas.forEach(item -> System.out.println(item));

    }
}
