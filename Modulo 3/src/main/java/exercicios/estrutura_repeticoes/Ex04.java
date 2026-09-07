package exercicios.estrutura_repeticoes;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qMaiorIdade = 0;

        for (int i = 0; i < 5; i++) {
            System.out.printf("Informe a idade da pessoa %d: ", i + 1);
            int idadePessoa = Integer.parseInt(sc.nextLine());

            if (idadePessoa > 18) {
                qMaiorIdade++;
            }
        }

        System.out.printf("Entre as pessoas citadas, %d tem uma idade maior que 18 anos.\n", qMaiorIdade);

        sc.close();
    }
}
