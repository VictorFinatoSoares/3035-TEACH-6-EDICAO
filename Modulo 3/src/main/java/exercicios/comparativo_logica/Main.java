package exercicios.comparativo_logica;

// Apenas por teste..

public class Main {
    public static void main(String[] args) {
        System.out.printf("1: %b%n", 10 >= 9);
        System.out.printf("2: %b%n", 10 - 21 / 7 >= 7);
        System.out.printf("3: %b%n", (1 > 2) && 17 > 10 - 2 * (3 - 1));
        System.out.printf("4: %b%n", 2 + 4 > 1 + 2 * 2);
        System.out.printf("5: %b%n", (10 * 2 - 1) > 10 && 10 >= 4 + 1 * 2);
        System.out.printf("6: %b%n", 10 > 2 || (5 * 2) + 10 / 2 + (10 * 3 / 2 + 1) > 20 * 3 - 1);
        System.out.printf("7: %b%n", (10 >= 2) || (10 - 2 <= 5 - 2 / 1));
        System.out.printf("8: %b%n", 10 + 2 + 4 / 4 >= 3 * 3 - 60 / 3 && 10 >= 60 / 6);
        System.out.printf("9: %b%n", 60 / 20 * 2 >= 7 - 1);
        System.out.printf("10: %b%n", !(60 / 20 * 2 >= 7 - 1));
        System.out.printf("11: %b%n", 10 > 2 || 60 > 20 * 3 - 1);
        System.out.printf("12: %b%n", 11 + 5 / 10 - 10 <= 10);
        System.out.printf("13: %b%n", true && true && false);
        System.out.printf("14: %b%n", true || false || false);
        System.out.printf("15: %b%n", true || !false || false);
        System.out.printf("16: %b%n", false && false || true);
        System.out.printf("17: %b%n", !false);
        System.out.printf("18: %b%n", !true);
        System.out.printf("19: %b%n", !true && true && !false);
        System.out.printf("20: %b%n", !(false && false || !true));
        System.out.printf("21: %b%n", 2 == 4 - 2 && true == true && 10 * 2 - 1 > 20);
        System.out.printf("22: %b%n", 10 >= 9 && 15 * 2 + 1 >= 31 && true);
        System.out.printf("23: %b%n", (2 >= 5) && (1 != 0) && !(6 <= 2 * 3) || (10 != 10));
        System.out.printf("24: %b%n", (5 != 2) || !(7 > 4) && (4 <= 1.344));
        System.out.printf("25: %b%n", (7 <= 8) == (3 / 2 == 1));
        System.out.printf("26: %b%n", 17.5 > 1 && (3.3 > 2));
        System.out.printf("27: %b%n", 6 > 3 + 8);
        System.out.printf("28: %b%n", 6 + 3 > 8);
        System.out.printf("29: %b%n", 4 > (2 + 9));
        System.out.printf("30: %b%n", 4 < 7 + 3);
        System.out.printf("31: %b%n", 4 < (7 * 5));
        System.out.printf("32: %b%n", 1 >= 2.5);
        System.out.printf("33: %b%n", (2 >= 5) && (1 != 0) && !(6 <= 2 * 3) || (10 == 10));
    }
}
