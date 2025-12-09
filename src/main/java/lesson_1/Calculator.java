package lesson_1;

import java.util.Scanner;
import java.util.Set;

public class Calculator {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static Set<String> supportedOperations = Set.of("+", "-", "*", "/", "^", "%");


    public static void main(String[] args) {
        System.out.println("Введите число");
        long firstNumber = SCANNER.nextLong();
        SCANNER.nextLine();
        String operation = "";
        while (!supportedOperations.contains(operation)) {
            System.out.println("Ввкдите операцию");
            operation = SCANNER.nextLine();
            if (!supportedOperations.contains(operation)) {
                System.out.println("Операция не поддерживается");
            }
        }
        System.out.println("Введите число");
        long secondNumber = SCANNER.nextLong();

        long result = switch (operation) {
            case "+" -> sum(firstNumber, secondNumber);
            case "-" -> subtract(firstNumber, secondNumber);
            case "*" -> multiply(firstNumber, secondNumber);
            case "/" -> divide(firstNumber, secondNumber);
            case "^" -> pow(firstNumber, secondNumber);
            case "%" -> mod(firstNumber, secondNumber);
            default -> 0;
        };
        System.out.println("Результат: " + result);


    }


    private static long sum(long firstNumber, long secondNumber) {
        return firstNumber + secondNumber;
    }

    private static long subtract(long firstNumber, long secondNumber) {
        return firstNumber - secondNumber;
    }

    private static long multiply(long firstNumber, long secondNumber) {
        return firstNumber * secondNumber;
    }

    private static long divide(long firstNumber, long secondNumber) {
        return firstNumber / secondNumber;
    }

    private static long mod(long firstNumber, long secondNumber) {
        return firstNumber % secondNumber;
    }

    private static long pow(long firstNumber, long secondNumber) {
        long result = 1;
        for (int i = 1; i <= secondNumber; i++) {
            result *= firstNumber;
        }
        return result;
    }
}
