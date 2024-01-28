import java.util.ArrayList;
public class Park {
    private ArrayList<Attraction> attractions = new ArrayList<>();

    public void addAttraction(String name, String timeOfWork, double cost) {
        attractions.add(new Attraction(name, timeOfWork, cost));
    }

    public void printAttractions() {
        for (Attraction attraction : attractions) {
            System.out.println("Attraction: " + attraction.getName() +
                    "\nTime of Work: " + attraction.getTimeOfWork() +
                    "\nCost: " + attraction.getCost() + "\n");
        }
    }

    private static class Attraction {
        private String name;
        private String timeOfWork;
        private double cost;

        public Attraction(String name, String timeOfWork, double cost) {
            this.name = name;
            this.timeOfWork = timeOfWork;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public String getTimeOfWork() {
            return timeOfWork;
        }

        public double getCost() {
            return cost;
        }
    }

    public static void main(String[] args) {
        Park park = new Park();
        park.addAttraction("Хали-гали", "10:00 - 18:00", 150.5);
        park.addAttraction("Паратрупер", "12:00 - 20:00", 100.0);
        park.addAttraction("Супер-8", "15:00 - 22:00", 120.5);

        park.printAttractions();
    }
}

