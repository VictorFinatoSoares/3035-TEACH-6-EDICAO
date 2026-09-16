package desafio;

import java.util.Scanner;
import java.util.Random;

public class JogoAdivinhacao {
    public static final Scanner sc = new Scanner(System.in);
    public static final Random random = new Random();
    public static boolean GAME_IS_RUNNING = true;

    // Configurações para cada dificuldade:
    public static final int[] NUMBER_LIMITS = {50, 100, 200};
    public static final int[] MAX_ATTEMPTS_CONFIG = {10, 7, 5};
    public static final int[] LEVEL_SCORES = {100, 200, 300};
    public static final String[] LEVEL_NAMES = {"FÁCIL", "MÉDIO", "DÍFICIL"};

    // Variáveis que a partida atual usa:
    public static int currentLevelIndex = 0;
    public static int numberLimit = 0;
    public static int maxAttempts = 0;
    public static int levelScore = 0;
    public static String currentLevelName = "";

    // Regras para a pontuação:
    public static int BONUS_SCORE = 50;
    public static int DISCOUNT_SCORE = 30;

    // Histórico de pontuações
    public static final int MAX_HISTORY = 10;
    public static int[] SCORE_RECORDS = new int[MAX_HISTORY];
    public static String[] LEVEL_RECORDS = new String[MAX_HISTORY];
    public static int TOTAL_GAMES_RECORDED = 0;


    public static void main(String[] args) {

    }

    public static void mainMenu() {
        System.out.println("""
                ====== MENU ======
                
                [1] Iniciar um novo jogo
                [2] Ver regras
                [3] Ver histórico de pontuações
                [4] Sair
                """);

        int opcao = lerNumeroInteiro("Escolha uma opção do menu: ");

        switch (opcao) {
            case 1:
                iniciarNovoJogo();
                break;
            case 2:
                verRegras();
                break;
            case 3:
                exibirPontuacoes();
                break;
            case 4:
                sair();
                break;
            default:
                System.out.println("ERRO: Essa opção não existe.");
                break;
        }
    }

    public static void definirDificuldade() {
        System.out.println("""
                ====== DIFICULDADES ======\s
                
                [1] Fácil -> Número entre 1 e 50, com 10 tentativas.
                [2] Médio -> Número entre 1 e 100, com 7 tentativas.
                [3] Díficil -> Número entre 1 200, com 5 tentativas.
                """);

        int dificuldade = lerNumeroInteiro("Escolha a dificuldade: ");
    }

    public static void iniciarNovoJogo() {

    }

    public static void verRegras() {
        System.out.println("""
                ====== REGRAS ======\s
           
                1. Quanto mais díficil, maior a recompensa recebida
                2. Cada tentativa gasta desconta 25 pontos
                3. Para cada tentativa sobrando, é recebido um bônus de 50 pontos.
                4. É possível visualizar apenas as últimas 10 pontuações.
                """);
    }

    public static void exibirPontuacoes() {

    }

    public static void sair() {
        System.out.println("Encerrando...");
        GAME_IS_RUNNING = false;
    }


    public static int lerNumeroInteiro(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Você precisa inserir um NÚMERO INTEIRO. Tente Novamente!");
            }
        }
    }
}