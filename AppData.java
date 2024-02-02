import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void save(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Записываем заголовок
            writer.write(String.join(";", header) + "\n");

            // Записываем данные
            for (int[] row : data) {
                writer.write(String.join(";", Arrays.stream(row).mapToObj(String::valueOf).toArray(String[]::new)) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Читаем заголовок
            String headerLine = reader.readLine();
            String[] header = headerLine.split(";");

            // Читаем данные
            List<int[]> rows = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] row = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
                rows.add(row);
            }

            int[][] data = rows.toArray(new int[0][]);
            return new AppData(header, data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Создаем объект AppData
        AppData appData = new AppData(
                new String[]{"Value 1", "Value 2", "Value 3"},
                new int[][]{{666, 666, 666}, {666, 666, 666}, {666, 666, 666}}
        );

        // Сохраняем данные в CSV файл
        appData.save("table.csv");

        // Загружаем данные из CSV файла
        AppData loadedData = AppData.load("table.csv");
        if (loadedData != null) {
            // Выводим заголовок
            System.out.println("Header: " + Arrays.toString(loadedData.getHeader()));

            // Выводим данные
            System.out.println("Data:");
            for (int[] row : loadedData.getData()) {
                System.out.println(Arrays.toString(row));
            }
        } else {
            System.out.println("Failed to load data.");
        }
    }
}