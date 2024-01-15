//MUHADMMAD ERFAN SYABIL BIN ESA
//B23CS0055
// Car.java
//Superclass
public abstract class Car implements Rentable {
    protected String make;
    protected String model;
    protected int year;
    protected double rentalRate;

    public Car(String make, String model, int year, double rentalRate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalRate = rentalRate;
    }

    public String getAllInfoCar() {
        return year + " " + make + " " + model;
    }
}