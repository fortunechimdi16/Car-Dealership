import java.util.ArrayList;
import java.util.List;

public class Dealership {

    public List<Car> inventory;
    static String report;

    public Dealership() {
        inventory = new ArrayList<>();
    }

    public void addCar(int year, String make, String model, String vin, long mileage, double cost,
                       boolean cleanRecord, String carImage) {

        if (inventory.size() == 10) {
            increaseSize();
        }

        inventory.add(new Car(year, make, model, vin, mileage, cost, cleanRecord, carImage));
    }

    public String toString() {
        report = "Number of Cars: " + inventory.size();
        return report;
    }

    private void increaseSize() {
        List<Car> temp = new ArrayList<>(inventory);
        inventory = temp;
    }

    public void initializeInventory() {
        addCar(2019, "Lexus", "LX570", "798672AK FCC695", 43035, 30582, true, "Lexus.jpg");
        addCar(2018, "Mercedes Benz", "C300", "508672AK FCC695", 34135, 40582, false, "Benz.jpg");
        addCar(2020, "Toyota", "Camry", "368672AK FCC695", 72035, 18000, false, "Toyota.jpg");
        addCar(2022, "Porsche", "Cayman", "458672AK FCC695", 21035, 45000, true, "Porsche.jpg");
    }
}
