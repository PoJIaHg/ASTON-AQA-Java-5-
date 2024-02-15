public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());

        System.out.println("Вес appleBox1: " + appleBox1.getWeight());
        System.out.println("Вес orangeBox1: " + orangeBox1.getWeight());
        System.out.println("Вес appleBox2: " + appleBox2.getWeight());

        System.out.println("Сравнение appleBox1 и orangeBox1: " + appleBox1.compare(orangeBox1));
        System.out.println("Сравнение appleBox1 и appleBox2: " + appleBox1.compare(appleBox2));

        appleBox1.transferTo(appleBox2);

        System.out.println("Вес appleBox1 после пересыпания: " + appleBox1.getWeight());
        System.out.println("Вес appleBox2 после пересыпания: " + appleBox2.getWeight());
    }
}