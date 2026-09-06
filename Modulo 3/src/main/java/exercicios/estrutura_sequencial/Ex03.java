package exercicios.estrutura_sequencial;

import java.util.Scanner;
import java.util.Locale;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale localeBrasil = new Locale("pt", "BR");
        System.out.print("Informe seu salário: ");
        double salario = Double.parseDouble(sc.nextLine().replace(",", "."));

        System.out.printf(localeBrasil, "Salário: R$ %.2f\n", salario);
        sc.close();
    }
}
