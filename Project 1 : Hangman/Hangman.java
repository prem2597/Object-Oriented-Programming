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
    private Movie selectRandomMovie(final ArrayList<Movie> levelMovies) {
        int randomIndex = (int) (Math.random() * levelMovies.size());
        Movie randomMovie = levelMovies.get(randomIndex);
        return randomMovie;
    }
    private String input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a character or hint ");
        String guess = "";
        if (scan.hasNext()) {
            guess = scan.next();
        } else {
            return guess;
        }
        if (guess.equals("hint")) {
            return guess;
        }
        if (guess.length() != 1) {
            System.out.println(" Enter only a single alphabet");
            return "one character";
        }
        int ascii = (int) (guess.charAt(0));
        final int start = 97;
        final int end = 122;
        if (ascii >= start && ascii <= end) {
            return guess;
        } else {
            System.out.println(" enter only a alphabet ");
            return "alphabetsOnly";
        }
    }
    private boolean isAlreadyGuessed(final String alreadyGuessed,final String guess) {
        int flag = alreadyGuessed.indexOf(guess);
        if (flag == -1) {
            return false;
        }
        return true;
    }
    private String format(final String form) {
        String temp = "";
        for (int i = 0; i < form.length(); i++) {
            temp = temp + form.charAt(i) + ",";
        }
        return temp;
    }
    private String tostring(final String[] form) {
        String temp = "";
        for (int i = 0; i < form.length; i++) {
            temp = temp + form[i] + " ";
        }
        temp = temp.substring(0, temp.length() - 1);
        return temp;
    }
    private boolean checkGuess(final String randomMovie, final String guess) {
        int flag = randomMovie.indexOf(guess);
        if (flag == -1) {
            return false;
        }
        return true;
    }
    private int getFrequency(final String randomMovieName,final String guess,final String[] guessedMovieName) {
        int frequency = 0;
        for (int i = 0; i < randomMovieName.length(); i++) {
            if (Character.toString(randomMovieName.charAt(i)).equals(guess)
                &&
                !guessedMovieName[i].equals(guess)) {
                frequency = frequency + 1;
            }
        }
        return frequency;
    }
    private String[] replaceWithGuess(final String randomMovieName,
            final String guess,
            final String[] guessedMovieName,
            final int frequency) {
        int index = -1;
        String[] tempGuessMovie = guessedMovieName;
        for (int i = 0; i < frequency; i++) {
            System.out.println(" correct !!! ");
            index = randomMovieName.indexOf(guess, index);
            if (!tempGuessMovie[index].equals(guess)) {
                tempGuessMovie[index] = guess;
            } else {
                index = randomMovieName.indexOf(guess, index + 1);
                if (index != -1) {
                    tempGuessMovie[index] = guess;
                }
            }
            index = index + 1;
        }
        return tempGuessMovie;
    }
    private String[] replaceWithUnderScores(final String movieName) {
        String[] guessedMovieName = new String[movieName.length()];
        for (int i = 0; i < movieName.length(); i++) {
            if (movieName.charAt(i) == '\'' || movieName.charAt(i) == ' ') {
                guessedMovieName[i] = Character.toString(movieName.charAt(i));
            } else {
                guessedMovieName[i] = "_";
            }
        }
        return guessedMovieName;
    }
    private void displayInfo(final String alphabetsRemaining,
                    final String alphabetsGuessed,
                    final String[] guessedMovieName) {
        System.out.println(" availableAlphabets = "
            + this.format(alphabetsRemaining));
        System.out.println(" alphabetsGuessed = "
            + this.format(alphabetsGuessed));
        System.out.println(" guessedMovieName = "
            + this.tostring(guessedMovieName));
    }
    private String[] putRandomChars(final String movieName,
                final String[] guessedMovieName) {
        final int three = 3;
        String[] temp = guessedMovieName;
        for (int i = 0; i < movieName.length() / three; i++) {
            int randomIndex = (int) (Math.random() * movieName.length());
            char c = movieName.charAt(randomIndex);
            temp[randomIndex] = Character.toString(c);
        }
        return temp;
    }
    private int numberOfLettersLeft(final String[] guessedMovieName) {
        int count = 0;
        for (int i = 0; i < guessedMovieName.length; i++) {
            if (guessedMovieName[i].equals("_")) {
                count++;
            }
        }
        return count;
    }
    public void readPlayerDetails(final int count) {
        Scanner sc = new Scanner(System.in);
        // System.out.println(" numberOfPlayers " + this.players.length);
        String playerName = "Player ";
        for (int i = 0; i < count; i++) {
            System.out.println(" enter Player " + (i + 1) + " Name ");
            if (sc.hasNext()) {
                playerName = sc.next();
            } else {
                System.out.println(" wrong input ... default name is used ");
                playerName = playerName + (i + 1);
            }
            Player temp = new Player(playerName, 0);
            this.players[i] = temp;
        }
    }
    public void playHangman(final int current) {

        try {
            System.out.println("Chance of Player Name "
                + this.players[current].getPlayerName());
            String choosenLevel = this.pickLevel();
            ArrayList<Movie> levelMovies = this.getDetails(choosenLevel);
            Movie randomMovie = this.selectRandomMovie(levelMovies);
            String randomMovieName = randomMovie.getMovieName();
            int randomMovieLength = randomMovie.getMovieName().length();
            String alphabetsRemaining = "abcdefghijklmnopqrstuvwxyz";
            String alphabetsGuessed = "";
            String[] guessedMovieName =
                this.replaceWithUnderScores(randomMovieName);
            int playerScore = 0;
            boolean hintTaken = false;
            guessedMovieName =
                this.putRandomChars(randomMovieName, guessedMovieName);
            int numberOfLettersLeft =
                this.numberOfLettersLeft(guessedMovieName);
            int maxGuesses = numberOfLettersLeft;
            System.out.println(" randomMovieName " + randomMovieName);
            System.out.println(" randomMovieLength " + randomMovieLength);
            System.out.println(" number of letters to guess "
                + numberOfLettersLeft);
            while (maxGuesses != 0 && numberOfLettersLeft != 0) {
                this.displayInfo(alphabetsRemaining,
                    alphabetsGuessed, guessedMovieName);
                String guess = this.takeInput();
                if (guess.equals("hint")) {
                    System.out.println(randomMovie.getCast() + " "
                         + randomMovie.getProduction());
                    hintTaken = true;
                    continue;
                }
                if (guess.length() != 1) {
                    continue;
                }
                boolean isGuessed = this.isAlreadyGuessed(alphabetsGuessed,
                            guess);
                if (!isGuessed) {
                    boolean isPresent = this.checkGuess(randomMovieName, guess);
                    if (isPresent) {
                        int frequency = this.getFrequency(randomMovieName,
                            guess, guessedMovieName
                            );
                        guessedMovieName =
                          this.replaceWithGuess(randomMovieName,
                             guess, guessedMovieName,
                             frequency
                             );
                        numberOfLettersLeft =
                             this.numberOfLettersLeft(
                                guessedMovieName
                                );
                        playerScore = playerScore + frequency;
                    } else {
                        System.out.println(" wrong !!! ");
                        playerScore--;
                        maxGuesses--;
                    }
                alphabetsRemaining = alphabetsRemaining.replaceAll(guess, "");
                    alphabetsGuessed = alphabetsGuessed + guess;
                } else {
                    System.out.println(" letter already guessed ");
                }
            }
            if (!hintTaken) {
                final int hundred = 100;
                playerScore = playerScore + hundred;
            }
            this.players[current].setPlayerScore(playerScore);
            System.out.println(" Name " + this.players[current].getPlayerName()
                +
                " playerScore " + this.players[current].getPlayerScore());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void leaderBoard() {
        System.out.println(players.length);
        if (this.players == null) {
            return;
        }
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = 0; j < players.length - i - 1; j++) {
                if (players[j].getPlayerScore()
                    <
                    players[j + 1].getPlayerScore()) {
                    Player temp = players[j];
                    players[j] = players[j + 1];
                    players[j + 1] = temp;
                }
            }
        }
        System.out.println(" LeaderBoard ");
        for (int i = 0; i < players.length; i++) {
            System.out.println(" playerName = " + players[i].getPlayerName()
                + " playerScore " + players[i].getPlayerScore());
        }
    }
}
