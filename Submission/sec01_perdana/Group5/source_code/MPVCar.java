//MPVCar.java

class MPVCar extends Car {
    public MPVCar(String make, String model, int year) {
        super(make, model, year, 100.0);
    }

    public double getRentalRate(){
        return 100.0; //Rate per day
    }
}
