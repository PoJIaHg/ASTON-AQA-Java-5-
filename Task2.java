import java.awt.Color;

// Интерфейс, представляющий геометрическую фигуру
interface Shape {
    // Методы для расчета периметра и площади
    double calculatePerimeter();

    double calculateArea();

    // Методы для получения цвета заливки и границы
    String getFillColor();

    String getBorderColor();

    // Дефолтный метод для вывода информации о фигуре
    default void printInfo() {
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area: " + calculateArea());
        System.out.println("Fill Color: " + getFillColor());
        System.out.println("Border Color: " + getBorderColor());
        System.out.println();
    }
}

// Класс, представляющий круг
class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    // Конструктор класса
    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    // Реализация методов интерфейса
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Реализация методов для получения цвета заливки и границы
    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс, представляющий прямоугольник
class Rectangle implements Shape {
    private double length;
    private double width;
    private String fillColor;
    private String borderColor;

    // Конструктор класса
    public Rectangle(double length, double width, String fillColor, String borderColor) {
        this.length = length;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    // Реализация методов интерфейса
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    // Реализация методов для получения цвета заливки и границы
    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс, представляющий треугольник
class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String borderColor;

    // Конструктор класса
    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    // Реализация методов интерфейса
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea() {
        // Формула Герона для нахождения площади треугольника
        double semiPerimeter = calculatePerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    }

    // Реализация методов для получения цвета заливки и границы
    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс для проверки работы программы
public class Task2 {
    public static void main(String[] args) {
        // Создаем объекты различных фигур
        Circle circle = new Circle(1, "Синий", "Синий");
        Rectangle rectangle = new Rectangle(6, 6, "Синий", "Синий");
        Triangle triangle = new Triangle(6, 6, 6, "Синий", "Синий");

        // Выводим информацию о каждой фигуре
        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}
