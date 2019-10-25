import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Prem
 */
class Hangman {
    /**
     * moviesDatabase is the array of movies.
     */
    private Moviedb moviesDatabase;
    /**
     * players contains their name and score.
     */
    private Player[] players;
    public Player[] getPlayers() {
        return players;
    }
    public void setPlayers(final Player[] players1) {
        this.players = players1;
    }
    public Moviedb getMovie() {
        return moviesDatabase;
    }
    public void setMovie(final Moviedb moviesDatabase1) {
        this.moviesDatabase = moviesDatabase1;
    }
    Hangman(final int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        moviesDatabase = new Moviedb();
    }
    private String pickLevel() {
        Scanner scan = new Scanner(System.in);
        System.out.println(" \n 1 : Easy \n 2 : Medium \n"
                            + "3 : Hard \n 4 : Random \n ");
        System.out.println("Enter the level which you want to play");
        int levelChoice;
        final int three = 3;
        final int four = 4;
        String choosenLevel = "";
        try {
            if (scan.hasNext()) {
                levelChoice = scan.nextInt();
            } else {
                System.out.println(" wrong input...");
                return "medium";
            }
            switch (levelChoice) {
                case 1:choosenLevel = "easy";
                break;
                case 2:choosenLevel = "medium";
                break;
                case three:choosenLevel = "hard";
                break;
                case four: int randomLevel = (int) (Math.random() * three) + 1;
                    switch (randomLevel) {
                        case 1:choosenLevel = "easy";
                        break;
                        case 2:choosenLevel = "medium";
                        break;
                        case three:choosenLevel = "hard";
                        break;
                        default:
                        break;
                    }
                break;
                default : choosenLevel = "medium";
            }
            System.out.println(" Selected level is " + choosenLevel);
            System.out.println("---------------------------------------------");
            return choosenLevel;
        } catch (InputMismatchException e) {
            System.out.println("wrong input... ");
            return "medium";
        }
    }
    public void setDetails(final String[] details) {
        final int four = 4;
        final int three = 3;
        for (int i = 0; i < details.length; i = i + four) {
            String movieName = details[i].toLowerCase();
            String level = details[i + 1].toLowerCase();
            String hint1 = details[i + 2];
            String hint2 = details[i + three];
            Movie movie = new Movie(movieName, level, hint1, hint2);
            if (level.equals("easy")) {
                this.moviesDatabase.setEasy(movie);
            } else if (level.equals("medium")) {
                this.moviesDatabase.setMedium(movie);
            } else if (level.equals("hard")) {
                this.moviesDatabase.setHard(movie);
            }
        }
    }
    private ArrayList<Movie> getDetails(final String choosenLevel) {
        if (choosenLevel.equals("easy")) {
            return this.moviesDatabase.getEasy();
        } else if (choosenLevel.equals("medium")) {
            return this.moviesDatabase.getMedium();
        } else {
            return this.moviesDatabase.getHard();
        }
        //  else if (choosenLevel.equals("hard")) {
        //     return this.moviesDatabase.getMedium();
        // }
    }
    private Movie selectRandomMovie(final ArrayList<Movie> levelMovies) {
        int randomIndex = (int) (Math.random() * levelMovies.size());
        Movie randomMovie = levelMovies.get(randomIndex);
        return randomMovie;
    }
    /**
     * @return guess value
     */
    private String takeInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("Enter a character..!!!");
        System.out.println("If you want a hint to "
        + "find the word then type hint or enter a character");
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
            System.out.println(" Enter only 1 alphabet ");
            return "Only one Character";
        }
        int ascii = (int) (guess.charAt(0));
        final int x = 97;
        final int y = 122;
        if (ascii >= x && ascii <= y) {
            return guess;
        } else {
            System.out.println(" Enter only an Alphabet ");
            return "Only letters from 'a' to 'z'";
        }
    }
    //  Checks if the letter is already guessed or not
    private boolean isAlreadyGuessed(final String alreadyGuessed,
            final String guess) {
        int flag = alreadyGuessed.indexOf(guess);
        if (flag == -1) {
            return false;
        }
        return true;
    }
    //  create a String where each character is separated by a comma
    private String format(final String data) {
        String temp = "";
        for (int i = 0; i < data.length(); i++) {
            temp = temp + data.charAt(i) + ",";
        }
        return temp;
    }
    //  create a string where each character is separated by a space
    private String arrToStr(final String[] data) {
        String temp = "";
        for (int i = 0; i < data.length; i++) {
            temp = temp + data[i] + " ";
        }
        temp = temp.substring(0, temp.length() - 1);
        return temp;
    }
    //  checks if the guessed letter is in movie name or not
    private boolean checkGuess(final String randomMovie, final String guess) {
        int flag = randomMovie.indexOf(guess);
        if (flag == -1) {
            return false;
        }
        return true;
    }
    //  counts the number of times the guessed letters in movie name
    private int getFrequency(final String randomMovieName,
            final String guess,
            final String[] guessedMovieName) {
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
    /**
     * replaced the guessed letter in gusessed movie
     * at the same position as in the movie name
     * @param randomMovieName // selects random movie
     * @param guess  // the word which we guess
     * @param guessedMovieName  // the updated name
     * @param frequency // counts the number of times the alphabet occurs
     * @return tempGuessedMovie
     */
    private String[] replaceWithGuess(final String randomMovieName,
            final String guess,
            final String[] guessedMovieName,
            final int frequency) {
        int index = -1;
        String[] tempGuessMovie = guessedMovieName;
        for (int i = 0; i < frequency; i++) {
            System.out.println(" correct !!! ");
            System.out.println("---------------------------------------------");
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
    /**
     * creates a new string array of movie name length.
     * this array contains underscores at each position
     * @param movieName // movieName is taken.
     * @return guessedMovieName
     */
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
    //  diaplay the information
    private void displayInfo(final String alphabetsRemaining,
                    final String alphabetsGuessed,
                    final String[] guessedMovieName,
                    final int numberOfLettersLeft) {
        System.out.println("---------------------------------------------");
        System.out.println("Available Number of chances :"
            + numberOfLettersLeft);
        System.out.println(" Available Alphabets = "
            + this.format(alphabetsRemaining));
        System.out.println(" AlphabetsGuessed = "
            + this.format(alphabetsGuessed));
        System.out.println(" guessedMovieName = "
            + this.arrToStr(guessedMovieName));
    }
    //  replace 1/3 of the words in the secret word
    private String[] putRandomChars(final String movieName,
                final String[] guessedMovieName) {
        String[] temp = guessedMovieName;
        final int three = 3;
        for (int i = 0; i < movieName.length() / three; i++) {
            int randomIndex = (int) (Math.random() * movieName.length());
            char c = movieName.charAt(randomIndex);
            temp[randomIndex] = Character.toString(c);
        }
        return temp;
    }
    //  finds the total number of letter left
    private int numberOfLettersLeft(final String[] guessedMovieName) {
        int count = 0;
        for (int i = 0; i < guessedMovieName.length; i++) {
            if (guessedMovieName[i].equals("_")) {
                count++;
            }
        }
        return count;
    }
    //  takes the player name
    public void readPlayerDetails(final int count) {
        Scanner sc = new Scanner(System.in);
        String playerName = "Player ";
        for (int i = 0; i < count; i++) {
            System.out.println(" Enter Player " + (i + 1) + " Name ");
            if (sc.hasNext()) {
                playerName = sc.next();
                System.out.println("----------------------"
                + "-----------------------");
            } else {
                System.out.println(" Wrong Input...!!!! ");
                System.out.println(" Player Name will be Default....!!!");
                playerName = playerName + (i + 1);
                System.out.println("----------------------"
                + "-----------------------");
            }
            Player temp = new Player(playerName, 0);
            this.players[i] = temp;
        }
    }
    //  hangman game
    // diaplays length of the movie to be guessed
    //  displays the missing lettres
    //  displays the movie name 1/3
    //  asks the  user to guess the movie
    // takes an input from the user
    //  checks the input is valisd or not
    // points gets added for each correct guess
    // negative score for each wrong guess
    // hint is not taken adds bonus points
    // game is over if the guessed becomes zero
    // set the score
    public void playHangman(final int current) {

        try {
            System.out.println("Turn of Player Name "
                + this.players[current].getPlayerName());
            String choosenLevel = this.pickLevel();
            ArrayList<Movie> levelMovies = this.getDetails(choosenLevel);
            Movie randomMovie = this.selectRandomMovie(levelMovies);
            String randomMovieName = randomMovie.getMovieName();
            int randomMovieLength = randomMovie.getMovieName().length();
            String alphabetsRemaining = "abcdefghijklmnopqrstuvwxyz";
            String alphabetsGuessed = "";
            final int m = 100;
            String[] guessedMovieName =
                this.replaceWithUnderScores(randomMovieName);
            int playerScore = 0;
            boolean hintTaken = false;
            guessedMovieName =
                this.putRandomChars(randomMovieName, guessedMovieName);
            int numberOfLettersLeft =
                this.numberOfLettersLeft(guessedMovieName);
            int maxGuesses = numberOfLettersLeft;
            // System.out.println(" randomMovieName " + randomMovieName);
            System.out.println(" randomMovieLength " + randomMovieLength);
            System.out.println(" number of letters to guess "
                + numberOfLettersLeft);
            while (maxGuesses != 0 && numberOfLettersLeft != 0) {
                this.displayInfo(alphabetsRemaining,
                    alphabetsGuessed, guessedMovieName, numberOfLettersLeft);
                // System.out.println("Number of chances");
                numberOfLettersLeft = numberOfLettersLeft - 1;
                String guess = this.takeInput();
                if (guess.equals("hint")) {
                    System.out.println(randomMovie.getHint2() + " "
                         + randomMovie.getHint1());
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
                playerScore = playerScore + m;
            }
            this.players[current].setPlayerScore(playerScore);
            System.out.println(" Name " + this.players[current].getPlayerName()
                +
                " playerScore " + this.players[current].getPlayerScore());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    //  sort the players based on score
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
            System.out.println(" PlayerName = " + players[i].getPlayerName()
                + ":  PlayerScore " + players[i].getPlayerScore());
        }
        System.out.println("Game Over !");
        System.out.println("Congratulations  " + "''" + players[0].getPlayerName() + "''");
        System.out.println("👍👍👍");
    }
}
