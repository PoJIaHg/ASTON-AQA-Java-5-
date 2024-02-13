import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>();
        collection.add("Highload");
        collection.add("High");
        collection.add("Load");
        collection.add("Highload");

        // 2.1.
        int highCount = countElement(collection, "High");
        System.out.println("Количество элементов 'High': " + highCount);

        // 2.2.
        String firstElement = getFirstElement(collection);
        System.out.println("Первый элемент: " + firstElement);

        // 2.3.
        String lastElement = getLastElement(collection);
        System.out.println("Последний элемент: " + lastElement);
    }

    private static int countElement(List<String> collection, String element) {
        return Collections.frequency(collection, element);
    }

    private static String getFirstElement(List<String> collection) {
        return collection.isEmpty() ? "0" : collection.get(0);
    }

    private static String getLastElement(List<String> collection) {
        return collection.isEmpty() ? "0" : collection.get(collection.size() - 1);
    }
}
