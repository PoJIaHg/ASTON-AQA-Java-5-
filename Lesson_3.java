import java.util.Arrays;

public class Lesson_3 {

    public static void main(String[] args) {
        // Задание 1
        System.out.println(isSumInRange(5, 5));

        // Задание 2
        printSign(0);

        // Задание 3
        System.out.println(isNegative(3));

        // Задание 4
        printStringMultipleTimes("Hello, Igor Kar", 3);

        // Задание 5
        System.out.println(isLeapYear(2024));

        // Задание 6
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1};
        invertArray(array1);
        System.out.println(Arrays.toString(array1));

        // Задание 7
        int[] array2 = fillArray(100);
        System.out.println(Arrays.toString(array2));

        // Задание 8
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyLessThan6(array3);
        System.out.println(Arrays.toString(array3));

        // Задание 9
        int size = 5;
        int[][] matrix = fillDiagonal(size);
        printMatrix(matrix);

        // Задание 10
        int[] array4 = createArray(6, 666);
        System.out.println(Arrays.toString(array4));
    }

    // Задание 1
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Задание 2
    public static void printSign(int number) {
        System.out.println((number >= 0) ? "Положительное число" : "Отрицательное число");
    }

    // Задание 3
    public static boolean isNegative(int number) {
        return number < 0;
    }

    // Задание 4
    public static void printStringMultipleTimes(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    // Задание 5
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Задание 6
    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    // Задание 7
    public static int[] fillArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // Задание 8
    public static void multiplyLessThan6(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    // Задание 9
    public static int[][] fillDiagonal(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            }
        return matrix;
    }

     public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Задание 10
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }
}
