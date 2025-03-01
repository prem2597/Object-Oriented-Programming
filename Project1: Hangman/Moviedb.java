import java.util.ArrayList;
class Moviedb {
    /**
     * easy is the arraylist with easy movies.
     */
    private ArrayList<Movie> easy;
    /**
     * medium is the arraylist with medium movies.
     */
    private ArrayList<Movie> medium;
    /**
     * hard is the arrayList with easy movies.
     */
    private ArrayList<Movie> hard;
    Moviedb() {
        easy = new ArrayList<>();
        medium = new ArrayList<>();
        hard = new ArrayList<>();
    }
    public ArrayList<Movie> getEasy() {
        return easy;
    }
    public void setEasy(final Movie easyMovies1) {
        this.easy.add(easyMovies1);
    }
    public ArrayList<Movie> getMedium() {
        return medium;
    }
    public void setMedium(final Movie mediumMovies1) {
        this.medium.add(mediumMovies1);
    }
    public ArrayList<Movie> getHard() {
        return hard;
    }
    public void setHard(final Movie hardMovies1) {
        this.hard.add(hardMovies1);
    }
}
