import java.text.NumberFormat;

public class Car {

    private String make, model, vin;
    public String carImage;
    private int year;
    private final Double cost;
    private final long mileage;
    private boolean cleanRecord;

    public Car(int year, String make, String model, String vin, long mileage, double cost, boolean cleanRecord, String carImage) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.mileage = mileage;
        this.cost = cost;
        this.cleanRecord = cleanRecord;
        this.carImage = carImage;
    }

    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String description = year + " " + model + "\nVIN #: " + vin + "\nMileage: " + mileage + "\nCost: $" + cost + "\n" ;

        if (cleanRecord) {
            description += "\tClean Record";
        } else {
            description += "\tAccidents Reported";


        }


        return description;
    }}