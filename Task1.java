class Animal {
    // Счетчик созданных животных
    private static int count = 0;

    String name;

    // Конструктор для создания животного
    Animal(String name) {
        this.name = name;
        count++;
    }

    // Геттер для подсчета созданных животных
    static int getCount() {
        return count;
    }

    // Метод для бега
    void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    // Метод для плавания
    void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }
}
class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    // Конструктор для создания собаки
    Dog(String name) {
        super(name);
    }

    // Переопределенный метод для вывода информации о беге
    @Override
    void run(int distance) {
        // Проверяем ограничение на дистанцию бега
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println("Собака не может пробежать так далеко!");
        }
    }

    // Переопределенный метод для вывода информации о плавании
    @Override
    void swim(int distance) {
        // Проверяем ограничение на дистанцию плавания
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println("Собака не может проплыть так далеко!");
        }
    }
}
class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean satiety;

    // Конструктор для создания кота
    Cat(String name) {
        super(name);
        satiety = false; // При создании кота он голоден
    }

    // Метод для плавания (переопределен)
    @Override
    void swim(int distance) {
        System.out.println("Кот не умеет плавать!");
    }

    // Метод для еды
    void eat(Bowl bowl, int foodAmount) {
        // Если в миске достаточно еды, кот кушает
        if (bowl.decreaseFood(foodAmount)) {
            System.out.println(name + " поел " + foodAmount + " еды.");
            satiety = true; // Кот становится сытым
        } else {
            System.out.println("В миске недостаточно еды для " + name + "!");
        }
    }

    // Геттер для получения сытости
    boolean isSatiety() {
        return satiety;
    }
}

class Bowl {
    private int foodAmount;

    // Конструктор для создания миски с начальным количеством еды
    Bowl(int initialFoodAmount) {
        this.foodAmount = Math.max(initialFoodAmount, 0);
    }

    // Метод для уменьшения количества еды в миске
    boolean decreaseFood(int foodAmount) {
        if (this.foodAmount >= foodAmount) {
            this.foodAmount -= foodAmount;
            return true; // Если есть достаточно еды, возвращаем true
        } else {
            return false; // Если нет достаточно еды, возвращаем false
        }
    }

    // Геттер для получения количества еды в миске
    int getFoodAmount() {
        return foodAmount;
    }

    // Метод для добавления еды в миску
    void addFood(int foodAmount) {
        this.foodAmount += Math.max(foodAmount, 0);
        System.out.println("Добавлено " + foodAmount + " еды в миску.");
    }
}

public class Task1 {
    public static void main(String[] args) {
        // Создаем миску с начальным количеством еды
        Bowl bowl = new Bowl(10);

        // Создаем массив котов
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Kompot");
        cats[1] = new Cat("Karamelka");
        cats[2] = new Cat("Korgik");

        // Добавляем еду в миску
        bowl.addFood(30);

        // Просим каждого кота покушать из миски
        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        // Выводим информацию о сытости котов в консоль
        for (Cat cat : cats) {
            System.out.println(cat.name + " сытость: " + cat.isSatiety());
        }

        // Выводим информацию о созданных животных
        System.out.println("Всего создано животных: " + Animal.getCount());

        // Пример вывода информации о бегущем и плывущем животном
        cats[0].run(150);
        cats[1].swim(5);
    }
}
