import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task5{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> logins = new ArrayList<>();
        while (true) {
            String login = scanner.nextLine().trim();
            if (login.isEmpty()) {
                break;
            }
            logins.add(login);
        }

        List<String> filteredLogins = logins.stream()
                .filter(login -> login.startsWith("f"))
                .collect(Collectors.toList());

        System.out.println("Логины, начинающиеся с 'f': " + filteredLogins);
    }
}
