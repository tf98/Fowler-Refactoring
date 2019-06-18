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
        double totalCharge = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for (Rental rental: rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.getCharge()) + "\n";
            totalCharge += rental.getCharge();
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalCharge) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

}