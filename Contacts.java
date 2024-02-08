import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {

        phoneBook.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String lastName) {

        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }

    public static void main(String[] args) {
        Contacts contact = new Contacts();

        contact.add("Ivanov", "123456789");
        contact.add("Petrov", "987654321");
        contact.add("Ivanov", "555555555");
        contact.add("Ololoev", "111111111");


        System.out.println("Номера телефонов Ivanov: " + contact.get("Ivanov"));
        System.out.println("Номера телефонов Petrov: " + contact.get("Petrov"));
        System.out.println("Номера телефонов Ololoev: " + contact.get("Ololoev"));
    }
}
