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
        while (GAME_IS_RUNNING) {
            mainMenu();
        }
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

    public static void definirDificuldade(){
        System.out.println("""
                ====== DIFICULDADES ======\s
                
                [1] Fácil -> Número entre 1 e 50, com 10 tentativas.
                [2] Médio -> Número entre 1 e 100, com 7 tentativas.
                [3] Díficil -> Número entre 1 200, com 5 tentativas.
                """);

        // Verifica se a dificuldade existe:
        while (true) {
            int dificuldade = lerNumeroInteiro("Escolha a dificuldade: ");

            if (dificuldade >= 1 && dificuldade <= 3) {
                numberLimit = NUMBER_LIMITS[dificuldade - 1];
                maxAttempts = MAX_ATTEMPTS_CONFIG[dificuldade - 1];
                levelScore = LEVEL_SCORES[dificuldade - 1];
                currentLevelName = LEVEL_NAMES[dificuldade - 1];
                break;
            } else {
                System.out.println("Essa dificuldade NÃO EXISTE!");
            }
        }
    }

    public static void iniciarNovoJogo() {
        definirDificuldade();

        int computerNumber = random.nextInt(numberLimit) + 1;
        int qTentativas = 0;

        while (qTentativas < maxAttempts) {
            int userNumber = lerNumeroInteiro("O computador pensou em um número, tente adivinhá-lo: ");

            if (userNumber == computerNumber) {
                System.out.println("Você ACERTOU! Parabéns!");
                int qTentativasSobrando = maxAttempts - qTentativas;

                levelScore = calcularPontuacao(qTentativasSobrando, qTentativas);

                if (TOTAL_GAMES_RECORDED < MAX_HISTORY) {
                    LEVEL_RECORDS[TOTAL_GAMES_RECORDED] = currentLevelName;
                    SCORE_RECORDS[TOTAL_GAMES_RECORDED] = levelScore;
                    TOTAL_GAMES_RECORDED++;
                } else {
                    for (int i = 0; i < MAX_HISTORY - 1; i++) {
                        LEVEL_RECORDS[i] = LEVEL_RECORDS[i + 1];
                        SCORE_RECORDS[i] = SCORE_RECORDS[i + 1];
                    }
                    LEVEL_RECORDS[MAX_HISTORY - 1] = currentLevelName;
                    SCORE_RECORDS[MAX_HISTORY - 1] = levelScore;
                }
                return;

            } else {
                if (userNumber > computerNumber) {
                    System.out.printf("O número é menor que %d!\n",  userNumber);
                } else {
                    System.out.printf("O número é maior que %d!\n", userNumber);
                }
            }
            qTentativas++;
        }
        System.out.printf("Ops... você não conseguiu acertar, o número era %d\n", computerNumber);
    }

    public static void verRegras() {
        System.out.println("""
                ====== REGRAS ======\s
           
                1. Quanto mais díficil, maior a recompensa recebida
                2. Cada tentativa gasta desconta 30 pontos
                3. Para cada tentativa sobrando, é recebido um bônus de 50 pontos.
                4. É possível visualizar apenas as últimas 10 pontuações.
                """);
    }

    public static int calcularPontuacao(int tentativasSobrando, int qErros) {
        return levelScore + (tentativasSobrando * BONUS_SCORE - qErros * DISCOUNT_SCORE);
    }

    public static void exibirPontuacoes() {
        for (int i = 0; i < TOTAL_GAMES_RECORDED; i++) {
            System.out.printf("%d - %s: %d pontos\n", i + 1, LEVEL_RECORDS[i], SCORE_RECORDS[i]);
        }
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