public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;

    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        priceCode = newpriceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    ;

    double getCharge(int daysRented) {
        double charge = 0;
        switch (priceCode) {
            case Movie.REGULAR:
                charge += 2;
                if (daysRented > 2)
                    charge += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                charge += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                charge += 1.5;
                if (daysRented > 3)
                    charge += (daysRented - 3) * 1.5;
                break;
        }
        return charge;
    }

    public int getFrequentRenterPoints(int daysRented) {
        // add bonus for a two day new release rental
        if ((priceCode == Movie.NEW_RELEASE) && daysRented > 1) return 2;
        return 1;
    }
}