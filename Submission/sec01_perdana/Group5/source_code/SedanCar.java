
//MUHADMMAD ERFAN SYABIL BIN ESA
//B23CS0055
//Sedan.java
//Subclass to Car
class SedanCar extends Car { //Shows Inheritance
    public SedanCar(String make, String model, int year) {
        super(make, model, year, 80.0);
    }

    public double getRentalRate(){
        return 80.0; //Rate per day
    }
}
