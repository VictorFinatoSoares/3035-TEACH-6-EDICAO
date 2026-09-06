package exercicios.estrutura_condicional;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int num = Integer.parseInt(sc.nextLine());


        if (num % 2 == 0) {
            num += 5;
        } else {
            num += 8;
        }

        System.out.printf("Resultado: %d", num);

        sc.close();
    }
}
