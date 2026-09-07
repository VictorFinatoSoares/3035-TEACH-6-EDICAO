package exercicios.estrutura_repeticoes;

import java.util.Random;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int randomNum = random.nextInt(101);

        int userNumber = 101;

        while (true) {
            System.out.print("Tente descobrir o número aleatório: ");
            userNumber = Integer.parseInt(sc.nextLine());

            if (userNumber > randomNum) {
                System.out.printf("O número aleatório é MENOR que %d!\n", userNumber);
            } else if (userNumber < randomNum) {
                System.out.printf("O número aleatório é MAIOR que %d!\n", userNumber);
            } else {
                System.out.println("PARABÉNS! VOCÊ ACERTOU!");
                break;
            }
        }

        sc.close();
    }
}
