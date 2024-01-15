//MUHADMMAD ERFAN SYABIL BIN ESA
//B23CS0055
//Compact.java
//Subclass to Car
class CompactCar extends Car{ //Shows Inheritance
    public CompactCar(String make, String model, int year) {
        super(make, model, year, 50.0);
    }

    public double getRentalRate(){
        return 50.0; //Rate per day
    }

    public String toString() {
        return "Compact: " + getMake() + " " + getModel() + " (" + getYear() + ")";
    }
    
}
