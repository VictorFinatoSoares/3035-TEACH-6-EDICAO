package exercicios.estrutura_sequencial;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Olá, por favor informe seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Agora, informe sua idade: ");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.printf("Nome: %s\n", nome);
        System.out.printf("Idade: %d\n", idade);

        sc.close();
    }
}
