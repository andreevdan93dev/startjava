package array;

import java.util.Random;

public class UniqNumbersArrayFiller {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        fillArray(-30, -10, 23);
        fillArray(10, 50, 10);
        fillArray(-34, -34, 1);
        fillArray(-1, 2, -3);
        fillArray(5, -8, 2);
    }


    private static void fillArray(int left, int right, int numsInRow) {
        if (numsInRow <= 0) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)\n", numsInRow);
            return;
        } else if (left > right) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)\n)", left, right);
            return;
        } else if (right - left <= 0) {
            System.out.printf("Длина массива должна быть > 0 (%d)\n", right - left);
            return;
        }

        int arrLen = (int) ((right - left) * 0.75);
        int[] arr = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            arr[i] = RANDOM.nextInt(left, right + 1);
        }

        printArray(arr, numsInRow);

    }

    private static void printArray(int[] arr, int numsInRow) {
        int counter = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < arr.length) {
            sb.append(arr[index++]);
            counter++;

            if (counter == numsInRow) {
                sb.append("\n");
                counter = 0;
            } else if (index < arr.length) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
