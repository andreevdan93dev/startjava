package calculator;

import calculator.exceptions.OperationNotSupportedException;
import calculator.exceptions.ZeroDivideException;

import java.util.Scanner;

public class CalculatorTest {
    private final static Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculate(calculator);
    }

    private static void calculate(Calculator calculator) {
        System.out.println("Введите число");
        long firstNumber = SCANNER.nextLong();
        SCANNER.nextLine();
        System.out.println("Ввкдите операцию");
        String operation = SCANNER.nextLine();
        System.out.println("Введите число");
        long secondNumber = SCANNER.nextLong();
        SCANNER.nextLine();
        try {
            long result = calculator.calculate(firstNumber, secondNumber, operation);
            System.out.println("Результат: " + result);
        } catch (ZeroDivideException e) {
            System.out.println("Ошибка: деление на ноль запрещено");
        } catch (OperationNotSupportedException e) {
            System.out.printf("Ошибка: операция '%s' не поддерживается%n", operation);
        } finally {
            continueCalculate(calculator);
        }
    }

    private static void continueCalculate(Calculator calculator) {
        System.out.println("Хотите продолжить вычисления? [yes/no]");

        switch (SCANNER.nextLine()) {
            case "yes":
                calculate(calculator);
            case "no":
                return;
            default:
                continueCalculate(calculator);
        }
    }


}
