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

    // [DESAFIO BÔNUS] Histórico de Recordes
    public static int[] BEST_SCORES = new int[3];
    public static int CURRENT_DIFFICULTY_INDEX = 0;

    // [DESAFIO BÔNUS] Loja de dicas
    public static int PARITY_HINT_COST = 10;
    public static int INTERVAL_HINT_COST = 20;
    public static int PROXIMITY_HINT_COST = 15;
    public static int TOTAL_HINTS_COST = 0;

    public static void main(String[] args) {
        while (GAME_IS_RUNNING) {
            mainMenu();
        }
    }

    public static void mainMenu() {
        System.out.println("""
                
                 ====== MENU PRINCIPAL ======
                
                 [1] Iniciar um novo jogo
                 [2] Iniciar modo com sequência (3 números)
                 [3] Ver regras
                 [4] Ver histórico de pontuações
                 [5] Ver histórico de recordes
                 [6] Sair
                
                """);

        int option = readIntegerNumber("Escolha uma opção do menu (1-6): ");

        switch (option) {
            case 1 -> startNewGame();
            case 2 -> startSequenceMode();
            case 3 -> showRules();
            case 4 -> showScoreHistory();
            case 5 -> showRecordsHistory();
            case 6 -> exitGame();
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
                CURRENT_DIFFICULTY_INDEX = difficulty - 1;
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

        int lastGuess = 0;
        TOTAL_HINTS_COST = 0;

        System.out.printf("""
                
                ====== O JOGO COMEÇOU! ======
                
                O computador pensou em um número entre 1 e %d, você consegue adivinhar em apenas %d tentativas?!
                
                """, numberLimit, maxAttempts);

        while (attemptsUsed <= maxAttempts) {
            int userNumber = readIntegerNumber("Tentativa (" + attemptsUsed + "/" + maxAttempts + ") [DIGITE 0 PARA UMA DICA]: ");

            if (userNumber == 0) {
                requestHint(computerNumber, lastGuess);
                continue;
            }

            lastGuess = userNumber;

            if (userNumber == computerNumber) {
                System.out.println("\nVocê ACERTOU! Parabéns!\n");
                int attemptsRemaining = maxAttempts - attemptsUsed;

                baseScore = calculateScore(attemptsRemaining, attemptsUsed);

                if (TOTAL_GAMES_SAVED < MAX_HISTORY) {
                    registerNewGame();
                } else {
                    overWriteHistory();
                }

                // [DESAFIO BÔNUS] Verifica se há um novo recorde e o registra
                registerNewRecord();

                return;
            } else {
                numberHint(userNumber, computerNumber);
            }

            attemptsUsed++;
        }

        System.out.printf("\nOps... suas tentativas acabaram e você não conseguiu acertar, o número era %d\n\n", computerNumber);
    }

    public static void startSequenceMode() {
        System.out.println("""
                
                ====== MODO SEQUÊNCIA ======
                
                O computador pensou em uma sequência de 3 números entre 1 e 20!
                Você tem 15 tentativas no total para acertar os 3 números. Boa sorte!
                
                """);

        int[] secretSequence = new int[3];

        for (int i = 0; i < secretSequence.length; i++) {
            secretSequence[i] = random.nextInt(20) + 1;
        }

        int totalAttempts = 15;
        int attemptsUsed = 1;

        for (int i = 0; i < secretSequence.length; i++) {
            int targetNumber = secretSequence[i];

            boolean foundCurrentNumber = false;
            System.out.printf("\nAdivinhe o número (%d) na sequência: ", i + 1);

            while (attemptsUsed <= totalAttempts) {
                int userNumber = readIntegerNumber("Tentativa (" + attemptsUsed + "/" + totalAttempts + "): ");

                if (userNumber == targetNumber) {
                    System.out.printf("VOCÊ ACERTOU! O número na posição %d era %d\n", i + 1, targetNumber);
                    foundCurrentNumber = true;
                    attemptsUsed++;
                    break;
                } else {
                    numberHint(userNumber, targetNumber);
                }

                attemptsUsed++;
            }

            if (!foundCurrentNumber) {
                System.out.printf("\nOps... suas tentativas acabaram! A sequência era: [%d, %d, %d]\n\n",
                        secretSequence[0], secretSequence[1], secretSequence[2]);
                return;
            }
        }

        System.out.printf("\nPARABÉNS! Você descobriu toda a sequência: [%d, %d, %d]!\n\n",
                secretSequence[0], secretSequence[1], secretSequence[2]);
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

    public static void registerNewRecord() {
        if (baseScore > BEST_SCORES[CURRENT_DIFFICULTY_INDEX]) {
            System.out.printf("\nPARABÉNS! Você quebrou seu antigo recorde (%d) na dificuldade %s!\n", BEST_SCORES[CURRENT_DIFFICULTY_INDEX], DIFFICULTY_NAMES_CONFIG[CURRENT_DIFFICULTY_INDEX]);
            BEST_SCORES[CURRENT_DIFFICULTY_INDEX] = baseScore;
        }
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
        return baseScore + (attemptsRemaining * BONUS_SCORE - attemptsUsed * DISCOUNT_SCORE) - TOTAL_HINTS_COST;
    }

    public static void showScoreHistory() {
        // Verifica se não há jogos salvos:
        if (TOTAL_GAMES_SAVED == 0) {
            System.out.println("\nNenhum jogo salvo ainda...\nComece a jogar agora mesmo para ver seu histórico!\n");
            return;
        }

        System.out.println("\n====== HISTÓRICO DE PONTUAÇÕES ======");

        for (int i = 0; i < TOTAL_GAMES_SAVED; i++) {
            System.out.printf("[JOGO %d] %s: %d PONTOS\n", i + 1, SAVED_DIFFICULTY_NAMES[i], SAVED_SCORES[i]);
        }
    }

    public static void showRecordsHistory() {
        System.out.println("\n====== HISTÓRICO DE RECORDES ======\n");

        for (int i = 0; i < BEST_SCORES.length; i++) {
            System.out.printf("[RECORDE] Dificuldade %s: %d pontos\n", DIFFICULTY_NAMES_CONFIG[i], BEST_SCORES[i]);
        }
    }

    public static void requestHint(int computerNumber, int lastGuess) {
        // [DESAFIO] BÔNUS
        System.out.println("""
                
                ====== LOJA DE DICAS ======
                
                [1] Paridade (Par/Ímpar) (-10 pontos)
                [2] Intervalo (Metade Superior/Inferior) (-20 pontos)
                [3] Proximidade (Quente/Frio) (-15 pontos)
                [4] Voltar ao jogo (sem dica)
                
                """);

        int choice = readIntegerNumber("Escolha uma dica (1-4): ");

        switch (choice) {
            case 1 -> {
                System.out.println(computerNumber % 2 == 0 ? "\nDICA: O número secreto é PAR!\n" : "\nDICA: O número secreto é ÍMPAR!\n");
                TOTAL_HINTS_COST += PARITY_HINT_COST;
            }
            case 2 -> {
                int halfNumberLimit = numberLimit / 2;

                if (computerNumber <= halfNumberLimit) {
                    System.out.printf("\nDICA: O número está na METADE INFERIOR (entre 1 e %d)!\n\n", halfNumberLimit);
                } else {
                    System.out.printf("\nDICA: O número está na METADE SUPERIOR (entre %d e %d)!\n\n", halfNumberLimit + 1, numberLimit);
                }

                TOTAL_HINTS_COST += INTERVAL_HINT_COST;
            }
            case 3 -> {
                if (lastGuess == 0) {
                    System.out.println("\nDICA: Você ainda não fez nenhum palpite para medir proximidade!\n");
                } else {
                    // A distância sempre será positiva (sendo o chute menor ou maior que o número pensado)
                    int distance = Math.abs(computerNumber - lastGuess);

                    if (distance <= 5) {
                        System.out.println("\nDICA: Está QUENTE! O número secreto está a 5 ou menos de distância do seu último chute!\n");
                    } else {
                        System.out.println("\nDICA: Está FRIO! O número secreto está a mais de 5 de distância do seu último chute!\n");
                    }

                    TOTAL_HINTS_COST += PROXIMITY_HINT_COST;
                }
            }
            case 4 -> System.out.println("\nVoltando ao jogo...\n");
            default -> System.out.println("\nOpção inválida! Nenhuma dica comprada.\n");
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