import java.util.Random;
import java.util.stream.IntStream;
public class Task1 {
    public static void main(String[] args) {
        int[] numbers = new Random().ints(20, 1, 101).toArray();

        long countEvenNumbers = IntStream.of(numbers)
                .filter(number -> number % 2 == 0)
                .count();

        System.out.println("Количество чётных чисел: " + countEvenNumbers);
    }
}