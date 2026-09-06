package exercicios.estrutura_condicional;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Informe seu sexo: ");
        char sexo = sc.nextLine().charAt(0);

        System.out.print("Informe seu estado civil: ");
        String estadoCivil = sc.nextLine();

        if (sexo == 'F' && estadoCivil.equalsIgnoreCase("CASADA")) {
            System.out.print("Informe quanto tempo de CASADA (ANOS): ");
            int tempoCasada = Integer.parseInt(sc.nextLine());

            System.out.printf("Olá, %s, você é %s a %d anos!", nome, estadoCivil.toLowerCase(), tempoCasada);
        }

        sc.close();
    }
}
