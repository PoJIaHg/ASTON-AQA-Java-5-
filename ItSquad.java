import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ItSquad {
    public static void main(String[] args) {
        String[] wordsArray = {"джун", "стажер", "мидл", "лид", "сеньор", "джун", "стажер", "индус", "хакер", "Алёша", "мидл", "сеньор"};

        Set<String> uniqueWords = new HashSet<>();
        Set<String> duplicateWords = new HashSet<>();
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : wordsArray) {
            if (!uniqueWords.add(word)) {
                // уже встречалось, добавляем в дубликаты
                duplicateWords.add(word);

                // увеличиваем счетчик повторений слова
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 1) + 1);
            }
        }

        // удаляем повторы из уникальных слов
        uniqueWords.removeAll(duplicateWords);

        System.out.println("Уникальные:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        System.out.println("\nПовторяющиеся:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
