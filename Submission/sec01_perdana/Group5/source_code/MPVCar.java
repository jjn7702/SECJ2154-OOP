//MUHADMMAD ERFAN SYABIL BIN ESA
//B23CS0055
//MPVCar.java
//Subclass to Car
class MPVCar extends Car { //Shows Inheritance
    public MPVCar(String type, String make, String model, int year) {
        super(type, make, model, year, 100.00);
    }

    public double getRentalRate(){
        return 100.00; //Rate per day
    }

    public String toString() {
        return getType() + "\t" + getMake() + "\t" + getModel() + "\t" + " (" + getYear() + ")";
    }
}
