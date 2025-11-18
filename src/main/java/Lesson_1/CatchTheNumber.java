package Lesson_1;

import java.util.Random;
import java.util.Scanner;

public class CatchTheNumber {
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int resultNumber = RANDOM.nextInt(100) + 1;
        System.out.println("Угадай число");
        int inputNumber = 0;
        while (resultNumber != inputNumber) {
            inputNumber = SCANNER.nextInt();
            if (inputNumber == resultNumber) {
                System.out.println("Верно");
            } else if (inputNumber > resultNumber) {
                System.out.printf("%d больше того, что загадал компьютер\n", inputNumber);
            } else {
                System.out.printf("%d меньше того, что загадал компьютер\n", inputNumber);
            }
        }
    }
}
