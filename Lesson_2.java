public class Lesson_2 {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    // Метод, печатающий три слова в столбец
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Метод, проверяющий знак суммы двух чисел
    public static void checkSumSign() {
        int a = 33;
        int b = -33;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Метод, определяющий цвет по значению
    public static void printColor() {
        int value = 100;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // Метод, сравнивающий два числа
    public static void compareNumbers() {
        int a = 111;
        int b = 111;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
