
//MUHADMMAD ERFAN SYABIL BIN ESA
//B23CS0055
//Sedan.java
//Subclass to Car
class SedanCar extends Car { //Shows Inheritance
    public SedanCar(String type, String make, String model, int year) {
        super(type, make, model, year, 80.00); //use super keyword to because of inheritance
    }

    public double getRentalRate(){
        return 80.00; //Rate per day
    }

    //toString() method is used to get the whole car name, make, model and year
    public String toString() {
        return getType() + "\t" + getMake() + "\t" + getModel() + "\t" + " (" + getYear() + ")";
    }
}
