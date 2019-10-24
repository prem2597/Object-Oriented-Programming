import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Hangman {
    private Moviedb allMovies;
    private Player[] allPlayers;
    private String availableLetters;
    private String usedLetters;
    private char[] word;
    Hangman(final int numberfPlayers) {
        System.out.println("Welcome to Hangman");
        allPlayers = new Player[numberOfPlayers];
        allMovies = new Moviedb();
    }
    public Player[] getPlayers() {
        return allPlayers;
    }
    public void setPlayers(final Player[] player1) {
        this.allPlayers = player1;
    }
    public Moviedb getMovie() {
        return allMovies;
    }
    public void setMovie(final Moviedb movie1) {
        this.allMovies = movie1;
    }
    private String selectLevel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 : Easy \n 2 : Medium \n 3 : Hard \n 4 : Random \n ");
        System.out.println("Enter the level");
        int level;
        String choice = "";
        try {
            if (sc.hasNext()) {
                level = sc.nextInt();
            } else {
                System.out.println("wrong input");
                System.out.println("Enter the Valid input in the range from 1 to 4 ");
            }
            switch (level) {
                case 1:choice = "easy";
                break;
                case 2:choice = "medium";
                break;
                case 3:choice = "hard";
                break;
                case 4: int randomLevel = (int) (Math.random() * 3) + 1;
                    switch (randomLevel) {
                        case 1:choice = "easy";
                        break;
                        case 2:choice = "medium";
                        break;
                        case 3:choice = "hard";
                        break;
                        default:
                        break;
                    }
                break;
                default : choice = "medium";
            }
            System.out.println(" selected level is " + choice);
            return choice;
        }
        catch (InputMismatchException e) {
            System.out.println("wrong input");
            System.out.println("Enter the Valid input in the range from 1 to 4 "); 
        }
    }
    public void setDeatils (final string[] details) {
        for (int i = 0; i < details.length; i = i + 4) {
            String movieName = details[i].toLowerCase();
            String level = details[i + 1].toLowerCase();
            String[] hint = {details[i + 2],details[i + 3] };
            Movie movie = new Movie(movieName, level, hint);
            if (level.equals("easy")) {
                this.allMovies.setEasy(movie);
            } else if (level.equals("medium")) {
                this.allMovies.setMedium(movie);
            } else if (level.equals("hard")) {
                this.allMovies.setHard(movie);
            }
        }
    }
    private ArrayList<Movie> getDetails(final String choosenLevel) {
        if (choosenLevel.equals("easy")) {
               return this.allMovies.getEasy();
        } else if (choosenLevel.equals("medium")) {
            return this.allMovies.getMedium();
        } else if (choosenLevel.equals("hard")) {
            return this.allMovies.getHard();
        }
    }
    private Movie selectMovie(final ArrayList<Movie> levelMovies) {
        int randomIndex = (int) (Math.random())
    }
}