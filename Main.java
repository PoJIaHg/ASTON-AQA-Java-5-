public class Main {

    public static void main(String[] args) {
        String[][] array = {
                {"#", "6", "6", "6"},
                {"6", "6", "6", "6"},
                {"6", "6", "6", "6"},
                {"6", "6", "6", "6"}
        };

        try {
            // Вызываем метод для суммирования значений массива
            int result = sumArrayValues(array);
            System.out.println("Sum: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            // Обрабатываем возможные исключения MyArraySizeException и MyArrayDataException
            System.err.println(e.getMessage());
        }
    }

    // Метод для суммирования значений двумерного строкового массива
    public static int sumArrayValues(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 || array[3].length != 4) {
            throw new MyArraySizeException("Array size must be 4x4.");
        }

        int sum = 0;

        // Проходим по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Преобразование строки в int и добавление к сумме
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Обработка ошибки преобразования
                    throw new MyArrayDataException("Invalid data format at cell [" + i + "][" + j + "].", e);
                }
            }
        }

        return sum;
    }
}

// Исключение для ситуации с некорректным размером массива
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

// Исключение для ситуации с некорректными данными в массиве
class MyArrayDataException extends Exception {
    public MyArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}