package lesson_1;

import java.util.Random;

public class RpsGameFormatting {
    private static final Random RANDOM = new Random();
    private static final String ROCK = "✊";
    private static final String SCISSORS = "✌️";
    private static final String PAPER = "✋";

    // Игра Камень-Ножницы-Бумага
    public static void main(String[] args) throws InterruptedException {

        String firstPlayer = "HEL";
        String firstPlayerSign = doChoosSign(firstPlayer);

        String secondPlayer = "WALLE";
        String secondPlayerSign = doChoosSign(secondPlayer);


        if (firstPlayerSign.equals(secondPlayerSign)) {
            System.out.println("Победила дружба!");
            return;
        }

        boolean isFirstPlayerWin = isPlayerWin(firstPlayerSign, secondPlayerSign);

        if (isFirstPlayerWin) {
            System.out.println("\nПобедил - " + firstPlayer);
        } else {
            System.out.println("\nПобедил - " + secondPlayer);
        }
    }

    private static String doChoosSign(String playerName) throws InterruptedException {
        int position = RANDOM.nextInt(1, 100);
        String sign = ROCK;
        System.out.println("Ход " + playerName + ": ");

        if (position > 66) {
            sign = PAPER;
        } else if (position > 33) {
            sign = SCISSORS;
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(ROCK + "\r");
            Thread.sleep(100);
            System.out.print(SCISSORS + "\r");
            Thread.sleep(100);
            System.out.print(PAPER + "\r");
            Thread.sleep(100);
        }
        System.out.println(sign);
        return sign;
    }

    private static boolean isPlayerWin(String playerSign, String enemySign) {
        return playerSign.equals(ROCK) && enemySign.equals(SCISSORS) ||
                playerSign.equals(SCISSORS) && enemySign.equals(PAPER) ||
                playerSign.equals(PAPER) && enemySign.equals(ROCK);
    }
}
