package array;

public class CalculateFactorial {
    public static void main(String[] args) {

        calculateFactorials();
        calculateFactorials(null);
        calculateFactorials(-5);
        calculateFactorials(21, 0, 7);
        calculateFactorials(1, 20, 5, -3);
    }


    private static void calculateFactorials(int... numbers) {
        if (numbers == null) {
            System.out.print("Ошибка: массив null\n");
        } else if (numbers.length == 0) {
            System.out.print("Ошибка: массив пустой\n");
        } else {
            for (int number : numbers) {
                if (number < 0) {
                    System.out.printf("Ошибка: факториал %d! не определен\n", number);
                } else if (number > 20) {
                    System.out.printf("Ошибка: факториал %d! слишком велик (максимум 20!)\n", number);
                } else {
                    StringBuilder factorialExpression = new StringBuilder(String.format("%d!", number));
                    if (number > 1) {
                        factorialExpression.append(" = 1");
                    }
                    long factorial = 1;
                    for (int i = 2; i <= number; i++) {
                        factorial *= i;
                        factorialExpression.append(" * ").append(i);
                    }
                    factorialExpression.append(String.format(" = %d", factorial)).append("\n");
                    System.out.printf(factorialExpression.toString());
                }
            }
        }
    }
}
