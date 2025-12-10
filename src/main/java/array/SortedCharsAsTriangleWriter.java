package array;

public class SortedCharsAsTriangleWriter {
    public static void main(String[] args) {
        writeChars('0', '9', true);
        writeChars('/', '!', false);
        writeChars('A', 'J', false);
    }


    private static void writeChars(char left, char right, boolean sort) {
        if (left > right) {
            System.out.printf("Ощибка: левая граница (%c) > правой (%c)\n", left, right);
            return;
        }
        char[] array = new char[right - left + 1];
        if (sort) {
            for (int i = left, j = 0; i <= right; i++, j++) {
                array[j] = (char) i;
            }
        } else {
            for (int i = right, j = 0; i >= left; i--, j++) {
                char current = (char) i;
                array[j] = current;
            }
        }
        printTriangle(array);
    }


    private static void printTriangle(char[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            int spaceCount = array.length - 1 - i;
            sb.append(" ".repeat(spaceCount));
            int charCount = 1 + i * 2;
            sb.append(String.valueOf(array[i]).repeat(charCount));
            if (i < array.length - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
