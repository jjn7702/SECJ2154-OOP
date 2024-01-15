import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    private List<Rental> rentals;

    public RentalSystem() {
        this.rentals = new ArrayList<>();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }
}
