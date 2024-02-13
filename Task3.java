import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4"));

        // Сортировка
        collection.sort((s1, s2) -> {
            if (s1.startsWith("f") && s2.startsWith("f")) {
                int num1 = Integer.parseInt(s1.substring(1));
                int num2 = Integer.parseInt(s2.substring(1));
                return Integer.compare(num1, num2);
            }
            return 0;
        });

        // Преобразование в массив
        String[] sortedArray = collection.toArray(new String[0]);

        // Вывод
        System.out.println("Отсортированный массив:");
        for (String element : sortedArray) {
            System.out.println(element);
        }
    }
}