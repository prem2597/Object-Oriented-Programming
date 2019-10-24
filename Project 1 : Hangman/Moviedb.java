import java.util.ArrayList;
public class Moviedb {
    private ArrayList<Movie> easy;
    private ArrayList<Movie> medium;
    private ArrayList<Movie> hard;
    Moviedb() {
        easy = new ArrayList<>();
        medium = new ArrayList<>();
        hard = new ArrayList<>();
    }
    public ArrayList<Movie> getEasy() {
        return easy;
    }
    public void setEasy(final Movie easyMovies) {
        this.easy.add(easyMovies);
    }
    public ArrayList<Movies> getMedium() {
        return medium;
    }
    public void setMedium(final Movie mediumMovies) {
        this.medium.add(mediumMovies);
    }
    public ArrayList<Movies> getHard() {
        return hard;
    }
    public void setHard(final Movie hardMovies) {
        this.hard.add(hardMovies);
    }
}