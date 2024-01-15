// Sports.java
class SportCar extends Car{
    public SportCar(String make, String model, int year) {
        super(make, model, year, 300.0);
    }

    public double getRentalRate(){
        return 300.0; //Rate per day
    }
}
