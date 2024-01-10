class SedanCar extends Car {
    public SedanCar(String make, String model, int year) {
        super(make, model, year, 80.0);
    }

    public double getRentalRate(){
        return 80.0; //Rate per day
    }
}
