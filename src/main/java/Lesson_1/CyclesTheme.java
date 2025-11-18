package Lesson_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        printAsciiSymbols();
        System.out.println();
        printGeometricFigure();
        System.out.println();
        printMultiplyTable();
        System.out.println();
        printNumbersFiveInLane();
        System.out.println();
        printNumberBetweenMinAndMax();
        System.out.println();
        anyOperationWithNumber();
        System.out.println();
        luckyNumberCheck();
        System.out.println();
        primitivePasswordGenerator();
        System.out.println();
    }

    private static void printAsciiSymbols() {
        System.out.println("DECIMAL, CHARACTER, DESCRIPTION");
        for (char c = 1; c <= 33; c += 2) {
            int dec = c;
            String character = String.valueOf(c);
            String description = Character.getName(c);
            System.out.printf("%6d%20s%40s\n", (int) c, character, description);
        }
    }

    private static void printGeometricFigure() {
        System.out.println("GEOMETRIC FIGURE");
        for (int i = 0; i < 5; i++) {
            System.out.print("---------- ");
            for (int j = 5; j > i; j--) {
                System.out.print("*");
            }
            System.out.print(" ");
            for (int j = 0; j <= i; j++) {
                System.out.print("^");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("^");
            }
            System.out.println();
        }
    }

    private static void printMultiplyTable() {
        int size = 9;
        int[][] multiplyTab = new int[size][size];

        for (int i = 0; i < size; i++) {
            if (i == 1) {
                System.out.println("-----+--------------------------------");
            }
            for (int j = 0; j < size; j++) {
                multiplyTab[i][j] = (i + 1) * (j + 1);
                if (i == 0 && j == 0) {
                    System.out.print("    ");
                } else {
                    System.out.printf("%4d", multiplyTab[i][j]);
                }
                if (j == 0) {
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
    }

    private static void printNumbersFiveInLane() {
        int max = 24;
        int iterationCount = max / 10;
        int counter = 1;
        for (int i = 0; i <= iterationCount; i++) {
            for (int j = 0; j < 10; j++) {
                int number = counter < max ? counter : 0;
                if (counter % 2 > 0) {
                    System.out.printf("%4d", number);
                }
                counter++;
            }
            System.out.println();
            if (counter >= max) {
                break;
            }
        }
    }

    private static void printNumberBetweenMinAndMax() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(-1);

        for (Integer number : numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        for (int i = max - 1; i > min; i--) {
            System.out.printf("%4d", i);
        }
        System.out.println();;
    }

    private static void anyOperationWithNumber() {
        int number = 2234321;
        int reversedNumber = Integer.parseInt(new StringBuilder().append(number).reverse().toString());
        int twoCount = 0;
        while (number > 0) {
            if (number % 10 == 2) {
                twoCount++;
            }
            number /= 10;
        }
        boolean isPalindrome = number == reversedNumber;
        System.out.printf("%d - %s с %s (%d) количеством двоек",
                reversedNumber,
                isPalindrome ? "палиндром" : "не палиндром",
                twoCount % 2 == 0 ? "четным" : "нечетным",
                twoCount);

    }

    private static void luckyNumberCheck() {
        int number = 101002;
        String strNum = String.valueOf(number);
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < strNum.length() / 2; i++) {
            char leftChar = strNum.charAt(i);
            char rightChar = strNum.charAt(strNum.length() - 1 - i);
            int leftDigit = Character.getNumericValue(leftChar);
            int rightDigit = Character.getNumericValue(rightChar);


            leftSum += leftDigit;
            rightSum += rightDigit;
        }
        System.out.printf("""
                        %d - %s
                        Сумма цифр %s = %d
                        Сумма цифр %s = %d
                        """,
                number,
                leftSum == rightSum ? "счастливое число" : "не счастливое число"
                , strNum.substring(0, strNum.length() / 2), leftSum,
                strNum.substring(strNum.length() / 2), rightSum
        );
    }

    private static void primitivePasswordGenerator() {
        Random random = new Random();
        int length = 8;
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append((char) (random.nextInt(33, 122)));
        }

        boolean isEnoughLong = password.length() >= length;
        boolean isContainLowCaseLetter = false;
        boolean isContainUpperCaseLetter = false;
        boolean isContainDigit = false;
        boolean isContainSpecialSymbol = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                isContainDigit = true;
            } else if (Character.isLetter(password.charAt(i)) && Character.isLowerCase(password.charAt(i))) {
                isContainLowCaseLetter = true;
            } else if (Character.isLetter(password.charAt(i)) && Character.isUpperCase(password.charAt(i))) {
                isContainUpperCaseLetter = true;
            } else {
                isContainSpecialSymbol = true;
            }
        }

        String passwordSecurityStatus;
        if (isEnoughLong && isContainLowCaseLetter && isContainUpperCaseLetter && isContainSpecialSymbol) {
            passwordSecurityStatus = "Надежный";
        } else if (isEnoughLong && (isContainUpperCaseLetter || isContainDigit)) {
            passwordSecurityStatus = "Средний";
        } else {
            passwordSecurityStatus = "Слабый";
        }

        System.out.printf("""
                Пароль: %s
                Надежность: %s
                """, password, passwordSecurityStatus);
    }
}
