import java.util.ArrayList;
import java.util.List;

// 1,2,3
class Fruit {

}

class Apple extends Fruit {

}

class Orange extends Fruit {

}

class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();



    // 4
    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit instanceof Apple ? 1.0f : 1.5f;
        }
        return weight;
    }

    // 5
    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    // 6
    public void transferTo(Box<? super T> anotherBox) {
        if (this == anotherBox) {
            System.out.println("Нельзя смешивать фрукты");
            return;
        }

        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }


    // 7
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public List<T> getFruits() {
        return fruits;
    }
}