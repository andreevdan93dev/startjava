package array;

public class ExceedingValueElementsRemover {
    private static final int ARRAY_LEN = 15;

    public static void main(String[] args) {
        removeElementsExceededThanValue(-1);
        removeElementsExceededThanValue(15);
        removeElementsExceededThanValue(0);
        removeElementsExceededThanValue(14);

    }

    private static void removeElementsExceededThanValue(Integer index) {
        if (index == null) {
            System.out.println("Ошибка: index не может быть null");
            return;
        }
        if (index < 0 || index > ARRAY_LEN - 1) {
            System.out.println("Ошибка: index не может быть меньше нуля или больше 14");
            return;
        }
        double[] array = generateArray();
        printArray("Исходный массив", array);
        double markerValue = array[index];
        for (int i = 0; i < ARRAY_LEN; i++) {
            if (array[i] > markerValue) {
                array[i] = 0;
            }
        }
        printArray("Измененный массив", array);

    }

    private static double[] generateArray() {
        double[] arr = new double[ARRAY_LEN];
        for (int i = 0; i < ARRAY_LEN; i++) {
            arr[i] = Math.random();
        }
        return arr;
    }

    private static void printArray(String arrayTitle, double[] arr) {
        StringBuilder sb = new StringBuilder(arrayTitle).append(":\n");
        for (int i = 0; i < arr.length; i++) {
            if (i == 8) {
                sb.append("\n");
            }
            sb.append(arr[i]);
            if (i < ARRAY_LEN - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
