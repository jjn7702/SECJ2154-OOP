//Compact.java

class CompactCar extends Car{
    public CompactCar(String make, String model, int year) {
        super(make, model, year, 50.0);
    }

    public double getRentalRate(){
        return 50.0; //Rate per day
    }
    
}
