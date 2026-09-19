package desafio;

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static final Scanner sc = new Scanner(System.in);
    public static final Random random = new Random();

    // Variável de controle geral
    public static boolean GAME_IS_RUNNING = true;

    // Configurações para cada dificuldade
    public static final int[] NUMBER_LIMITS_CONFIG = {50, 100, 200};
    public static final int[] MAX_ATTEMPTS_CONFIG = {10, 7, 5};
    public static final int[] DIFFICULTY_BASE_SCORES_CONFIG = {100, 200, 300};
    public static final String[] DIFFICULTY_NAMES_CONFIG = {"FÁCIL", "MÉDIO", "DÍFICIL"};

    // Variáveis que a partida atual usa
    public static int numberLimit = 0;
    public static int maxAttempts = 0;
    public static int baseScore = 0;
    public static String currentLevelDifficulty = "";

    // Regras para a pontuação
    public static int BONUS_SCORE = 50;
    public static int DISCOUNT_SCORE = 30;

    // Histórico de pontuações
    public static final int MAX_HISTORY = 10;
    public static int[] SAVED_SCORES = new int[MAX_HISTORY];
    public static String[] SAVED_DIFFICULTY_NAMES = new String[MAX_HISTORY];
    public static int TOTAL_GAMES_SAVED = 0;

    public static void main(String[] args) {
        while (GAME_IS_RUNNING) {
            mainMenu();
        }
    }

    public static void mainMenu() {
        System.out.println("""
           
                ====== MENU PRINCIPAL ======
               
                [1] Iniciar um novo jogo
                [2] Ver regras
                [3] Ver histórico de pontuações
                [4] Sair
               
               """);

        int option = readIntegerNumber("Escolha uma opção do menu (1-4): ");

        switch (option) {
            case 1 -> startNewGame();
            case 2 -> showRules();
            case 3 -> showScoreHistory();
            case 4 -> exitGame();
            default -> System.out.println("ERRO: Essa opção não existe no menu!\n");
        }
    }

    public static void chooseDifficulty() {
        System.out.println("""
            
                ====== DIFICULDADES ======
                
                [1] FÁCIL
                [2] MÉDIO
                [3] DIFÍCIL
                
                """);

        while (true) {
            int difficulty = readIntegerNumber("Escolha a dificuldade: ");

            // Verifica se a dificuldade existe
            if (difficulty >= 1 && difficulty <= 3) {
                numberLimit = NUMBER_LIMITS_CONFIG[difficulty - 1];
                maxAttempts = MAX_ATTEMPTS_CONFIG[difficulty - 1];
                baseScore = DIFFICULTY_BASE_SCORES_CONFIG[difficulty - 1];
                currentLevelDifficulty = DIFFICULTY_NAMES_CONFIG[difficulty - 1];
                break;
            } else {
                System.out.println("ERRO: Essa dificuldade não existe!\n");
            }
        }
    }

    public static void startNewGame() {
        chooseDifficulty();

        int computerNumber = random.nextInt(numberLimit) + 1;
        int attemptsUsed = 1;

        System.out.printf("""
                
                ====== O JOGO COMEÇOU! ======
                
                O computador pensou em um número entre 1 e %d, você consegue adivinhar em apenas %d tentativas?!
                
                """, numberLimit, maxAttempts);

        while (attemptsUsed <= maxAttempts) {
            int userNumber = readIntegerNumber("Tentativa (" + attemptsUsed + "/" + maxAttempts + "): ");

            if (userNumber == computerNumber) {
                System.out.println("\nVocê ACERTOU! Parabéns!\n");
                int attemptsRemaining = maxAttempts - attemptsUsed;

                baseScore = calculateScore(attemptsRemaining, attemptsUsed);

                if (TOTAL_GAMES_SAVED < MAX_HISTORY) {
                    registerNewGame();
                } else {
                   overWriteHistory();
                }

                return;
            } else {
                numberHint(userNumber, computerNumber);
            }

            attemptsUsed++;
        }

        System.out.printf("\nOps... suas tentativas acabaram e você não conseguiu acertar, o número era %d\n\n", computerNumber);
    }

    public static void registerNewGame() {
        SAVED_DIFFICULTY_NAMES[TOTAL_GAMES_SAVED] = currentLevelDifficulty;
        SAVED_SCORES[TOTAL_GAMES_SAVED] = baseScore;
        TOTAL_GAMES_SAVED++;
    }

    public static void overWriteHistory() {
        // Desloca todos os jogos salvos pra a esquerda (o primeiro jogo salvo no array desaparece)
        for (int i = 0; i < MAX_HISTORY - 1; i++) {
            SAVED_DIFFICULTY_NAMES[i] = SAVED_DIFFICULTY_NAMES[i + 1];
            SAVED_SCORES[i] = SAVED_SCORES[i + 1];
        }

        // Registra o jogo atual na última posição
        SAVED_DIFFICULTY_NAMES[MAX_HISTORY - 1] = currentLevelDifficulty;
        SAVED_SCORES[MAX_HISTORY - 1] = baseScore;
    }

    public static void numberHint(int userNumber, int computerNumber) {
        System.out.printf(userNumber > computerNumber ? "\nO número precisa ser menor que %d\n\n" : "\nO número precisa ser maior que %d\n\n", userNumber);
    }

    public static void showRules() {
        System.out.println("""
                
                ======================= REGRAS DO JOGO =======================
                
                [1] OBJETIVO:
                   Descubra o número secreto sorteado pelo computador com o menor
                   número de tentativas possível!
                
                [2] NÍVEIS DE DIFICULDADE:
                   - Fácil:   Número entre 1 e 50  | 10 tentativas | Pontuação base: 100
                   - Médio:   Número entre 1 e 100 |  7 tentativas | Pontuação base: 200
                   - Difícil: Número entre 1 e 200 |  5 tentativas | Pontuação base: 300
                
                [3] DICAS AUTOMÁTICAS:
                   A cada erro, o jogo avisa se o número secreto é MAIOR ou MENOR
                   que o seu palpite.
                
                [4] SISTEMA DE PONTUAÇÃO:
                   - Cada erro desconta 30 pontos.
                   - Cada tentativa não utilizada soma +50 pontos de bônus!
                   - Fórmula: Pontuação Base + (Tentativas Sobrando * 50) - (Erros * 30)
                
                [5] HISTÓRICO:
                   O sistema armazena e exibe as suas últimas 10 pontuações.
                
                """);
    }

    public static int calculateScore(int attemptsRemaining, int attemptsUsed) {
        return baseScore + (attemptsRemaining * BONUS_SCORE - attemptsUsed * DISCOUNT_SCORE);
    }

    public static void showScoreHistory() {
        // Verifica se não há jogos salvos:
        if (TOTAL_GAMES_SAVED == 0) {
            System.out.println("Nenhum jogo salvo ainda...\nComece a jogar agora mesmo para ver seu histórico!\n");
            return;
        }

        for (int i = 0; i < TOTAL_GAMES_SAVED; i++) {
            System.out.printf("[JOGO %d] %s: %d PONTOS\n", i + 1, SAVED_DIFFICULTY_NAMES[i], SAVED_SCORES[i]);
        }
    }

    public static void exitGame() {
        System.out.println("Saindo do jogo... Até a próxima!");
        GAME_IS_RUNNING = false;
    }

    public static int readIntegerNumber(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Você precisa inserir um NÚMERO INTEIRO. Tente Novamente!\n");
            }
        }
    }
}