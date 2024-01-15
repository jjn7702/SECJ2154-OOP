//MUHADMMAD ERFAN SYABIL BIN ESA
//B23CS0055
//MPVCar.java
//Subclass to Car
class MPVCar extends Car { //Shows Inheritance
    public MPVCar(String make, String model, int year) {
        super(make, model, year, 100.0);
    }

    public double getRentalRate(){
        return 100.0; //Rate per day
    }

    public String toString() {
        return "MPV: " + getMake() + " " + getModel() + " (" + getYear() + ")";
    }
}
