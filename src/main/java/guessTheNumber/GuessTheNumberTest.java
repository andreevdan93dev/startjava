package guessTheNumber;

import java.util.Scanner;

public class GuessTheNumberTest {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Первый игрок представьтесь!");
        Player firstPlayer = new Player(SCANNER.nextLine());
        System.out.println("Второй игрок представьтесь!");
        Player secondPlayer = new Player(SCANNER.nextLine());
        GuessNumber guessNumber = new GuessNumber(firstPlayer, secondPlayer);

        boolean isContinue = true;
        while (isContinue) {
            guessNumber.startGuess();
            isContinue = wantContinue();
        }

    }

    private static boolean wantContinue() {
        System.out.println("Хотите продолжить игру? [yes/no]");
        String answer = SCANNER.nextLine();
        return switch (answer) {
            case "yes" -> true;
            case "no" -> false;
            default -> wantContinue();
        };
    }
}
