import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private List<Rental> rentals = new LinkedList<>();

    public Customer(String newname) {
        name = newname;
    }

    ;

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    ;

    public String getName() {
        return name;
    }

    ;

    public String statement() {
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for (Rental rental: rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double totalCharge = 0;
        for (Rental rental : rentals) {
            totalCharge += rental.getCharge();
        }
        return totalCharge;
    }
    }

}