package calculator;

import calculator.exceptions.OperationNotSupportedException;
import calculator.exceptions.ZeroDivideException;

import static calculator.Operand.*;

public class Calculator {

    public long calculate(long firstNumber, long secondNumber, String operation)
            throws OperationNotSupportedException, ZeroDivideException {
        Operand operand = parse(operation);

        return switch (operand) {
            case SUM_OPERAND -> sum(firstNumber, secondNumber);
            case SUBTRACT_OPERAND -> subtract(firstNumber, secondNumber);
            case MULTIPLY_OPERAND -> multiply(firstNumber, secondNumber);
            case DIVIDE_OPERAND -> divide(firstNumber, secondNumber);
            case POWER_OPERAND -> pow(firstNumber, secondNumber);
            case MOD_OPERAND -> mod(firstNumber, secondNumber);
        };
    }

    private long sum(long firstNumber, long secondNumber) {
        return firstNumber + secondNumber;
    }

    private long subtract(long firstNumber, long secondNumber) {
        return firstNumber - secondNumber;
    }

    private long multiply(long firstNumber, long secondNumber) {
        return firstNumber * secondNumber;
    }

    private long divide(long firstNumber, long secondNumber) throws ZeroDivideException {
        if (secondNumber == 0) {
            throw new ZeroDivideException();
        }
        return firstNumber / secondNumber;
    }

    private long mod(long firstNumber, long secondNumber) throws ZeroDivideException {
        if (secondNumber == 0) {
            throw new ZeroDivideException();
        }
        return firstNumber % secondNumber;
    }

    private long pow(long firstNumber, long secondNumber) {
        long result = 1;
        for (int i = 1; i <= secondNumber; i++) {
            result *= firstNumber;
        }
        return result;
    }
}
