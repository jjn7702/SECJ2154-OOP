//MUHADMMAD ERFAN SYABIL BIN ESA
//B23CS0055
// Car.java
//Superclass
public abstract class Car implements Rentable {
    protected String type;
    protected String make;
    protected String model;
    protected int year;
    protected double rentalRate;

    public Car(String type, String make, String model, int year, double rentalRate) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalRate = rentalRate;
    }

    public String getType(){
        return type;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
        return year;
    }

    public abstract double getRentalRate();
}