package calculator;

import calculator.exceptions.OperationNotSupportedException;

public enum Operand {
    SUM_OPERAND("+"),
    SUBTRACT_OPERAND("-"),
    MULTIPLY_OPERAND("*"),
    DIVIDE_OPERAND("/"),
    MOD_OPERAND("%"),
    POWER_OPERAND("^");

    private final String symbol;

    Operand(String symbol) {
        this.symbol = symbol;
    }

    public static Operand parse(String symbol) throws OperationNotSupportedException {
        for (Operand operand : values()) {
            if (operand.symbol.equals(symbol)) {
                return operand;
            }
        }
        throw new OperationNotSupportedException();
    }
}
