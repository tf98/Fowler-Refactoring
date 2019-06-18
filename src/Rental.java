class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getCharge() {
        double charge = 0;
        switch (movie.getPriceCode()) {
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
}