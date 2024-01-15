//MUHADMMAD ERFAN SYABIL BIN ESA
//B23CS0055
// Sports.java
//Subclass to Car
class SportCar extends Car{ //Shows Inheritance
    public SportCar(String make, String model, int year) {
        super(make, model, year, 300.0);
    }

    public double getRentalRate(){
        return 300.0; //Rate per day
    }

    public String toString() {
        return "Sports: " + getMake() + " " + getModel() + " (" + getYear() + ")";
    }
}
