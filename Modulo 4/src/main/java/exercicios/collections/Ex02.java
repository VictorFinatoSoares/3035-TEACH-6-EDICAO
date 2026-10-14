package exercicios.collections;

import java.util.HashSet;

public class Ex02 {
    public static void main(String[] args) {
        HashSet<String> cores = new HashSet<>();

        cores.add("Azul");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Branco");

        System.out.println(cores.size());

        // Elementos idênticos são excluídos, mantendo apenas um de cada conteúdo
        cores.add("Azul");

        cores.remove("Vermelho");

        System.out.println(cores.contains("Laranja") ? "Laranja está no arraylist!" : "Laranja não está no arraylist!");
        cores.add("Laranja");

        cores.forEach(item -> System.out.println(item));

    }
}
