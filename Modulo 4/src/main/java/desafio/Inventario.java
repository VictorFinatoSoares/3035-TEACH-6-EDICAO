package desafio;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    // A lista permite multíplos itens de mesmo tipo
    private final List<String> itens = new ArrayList<>();

    public void adicionar(String item) {
        itens.add(item);
    }

    public int contar(String item) {
        return (int) itens.stream().filter(item::equals).count();
    }

    public boolean remover(String item) {
        return itens.remove(item);
    }
}
