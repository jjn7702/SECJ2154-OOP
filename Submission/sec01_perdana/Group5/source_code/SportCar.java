//MUHADMMAD ERFAN SYABIL BIN ESA
//B23CS0055
// Sports.java
//Subclass to Car
class SportCar extends Car{ //Shows Inheritance
    public SportCar(String type, String make, String model, int year) {
        super(type, make, model, year, 300.00);
    }

    public double getRentalRate(){
        return 300.00; //Rate per day
    }

    public String toString() {
        return getType() + "\t" + getMake() + "\t" + getModel() + "\t" + " (" + getYear() + ")";
    }
}
