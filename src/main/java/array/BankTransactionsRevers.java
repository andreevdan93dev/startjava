package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BankTransactionsRevers {
    public static void main(String[] args) {
        int[] input1 = new int[0];
        int[] input2 = null;
        int[] input3 = {5};
        int[] input4 = {6, 8, 9, 1};
        int[] input5 = {13, 8, 5, 3, 2, 1, 1};

        printReversedTransactions(input1);
        printReversedTransactions(input2);
        printReversedTransactions(input3);
        printReversedTransactions(input4);
        printReversedTransactions(input5);

    }


    private static void printReversedTransactions(int[] transactions) {

        if (transactions == null) {
            System.out.print("""
                    Исходные транзакции: null
                     В обратном порядке: null
                    """);
        } else if (transactions.length == 0) {
            System.out.print("""
                    Исходные транзакции: []
                     В обратном порядке: []
                    """);
        } else {
            int[] reversedTransactions = new int[transactions.length];
            for (int i = transactions.length - 1, j = 0; i >= 0; i--, j++) {
                reversedTransactions[j] = transactions[i];
            }
            System.out.printf("""
                            Исходные транзакции: %s
                             В обратном порядке: %s
                            """,
                    Arrays.toString(transactions), Arrays.toString(reversedTransactions));
        }
    }


}
