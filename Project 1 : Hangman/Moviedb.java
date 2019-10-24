import java.util.ArrayList;
class MovieDb {
    private ArrayList<Movie> easyMovies;
    private ArrayList<Movie> mediumMovies;
    private ArrayList<Movie> hardMovies;
    MovieDb() {
        easyMovies = new ArrayList<>();
        mediumMovies = new ArrayList<>();
        hardMovies = new ArrayList<>();
    }
    public ArrayList<Movie> getEasyMovies() {
        return easyMovies;
    }

    public void setEasyMovies(final Movie easyMovies1) {
        this.easyMovies.add(easyMovies1);
    }

    public ArrayList<Movie> getMediumMovies() {
        return mediumMovies;
    }

    public void setMediumMovies(final Movie mediumMovies1) {
        this.mediumMovies.add(mediumMovies1);
    }

    public ArrayList<Movie> getHardMovies() {
        return hardMovies;
    }

    public void setHardMovies(final Movie hardMovies1) {
        this.hardMovies.add(hardMovies1);
    }
}