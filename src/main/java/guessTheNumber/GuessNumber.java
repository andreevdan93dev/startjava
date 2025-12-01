package guessTheNumber;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Player firstPlayer;
    private final Player secondPlayer;
    private int guessNumber;

    public GuessNumber(Player firstPlayer,
                       Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void startGuess() {
        setGuessNumber();
        System.out.printf("%s, %s, добро пожаловать в угодай число\n", firstPlayer.getName(), secondPlayer.getName());
        int inputNumber = 0;
        Player player = getStartPlayer();
        while (guessNumber != inputNumber) {
            System.out.printf("%s, Угадай число\n", player.getName());
            inputNumber = SCANNER.nextInt();
            if (inputNumber == guessNumber) {
                System.out.println("Верно");
                System.out.printf("%s победил!\n", player.getName());
            } else if (inputNumber > guessNumber) {
                System.out.printf("%d больше того, что загадал компьютер\n", inputNumber);
            } else {
                System.out.printf("%d меньше того, что загадал компьютер\n", inputNumber);
            }
            player = getNextPlayer(player);
        }
    }

    private Player getNextPlayer(Player player) {
        if (Objects.equals(firstPlayer, player)) {
            return secondPlayer;
        } else {
            return firstPlayer;
        }

    }

    private void setGuessNumber() {
        guessNumber = RANDOM.nextInt(100) + 1;
    }

    private Player getStartPlayer() {
        int random = RANDOM.nextInt(1000) + 1;
        if (random % 2 == 1) {
            return firstPlayer;
        } else {
            return secondPlayer;
        }
    }
}
