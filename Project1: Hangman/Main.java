import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public final class Main {
    private Main() {
    }
    private static String[] readFile(final String fileName)
    throws FileNotFoundException {
    try {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        ArrayList<String> lines = new ArrayList<String>();
        while (scan.hasNextLine()) {
            String temp = scan.nextLine();
            if (temp.length() != 0) {
                lines.add(temp);
            }
        }
        String[] fileContents = lines.toArray(new String[lines.size()]);
        return fileContents;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /**
     * Main method to start the program.
     * @param args type
     */
    public static void main(final String[] args) {
        System.out.println("Welcome to Hangman");
        System.out.println("😃😃😃");
        System.out.println(" Enter the number of players ");
        int numberOfPlayers = 1;
        Scanner sc = new Scanner(System.in);
        try {
            if (sc.hasNext()) {
                numberOfPlayers = sc.nextInt();
            }
        } catch (InputMismatchException is) {
            System.out.println("Wrong Input ....");
            System.out.println("Number of players must be a number...!!!!");
            System.out.println("Default number of players 1");
            System.out.println("---------------------------------------------");
        }
        try {
            System.out.println(" Number of Players" + numberOfPlayers);
            System.out.println("---------------------------------------------");
            String[] fileContents = readFile("movies.txt");
            if (fileContents == null) {
                throw new NullPointerException();
            }
            Hangman hangman = new Hangman(numberOfPlayers);
            hangman.setDetails(fileContents);
            hangman.readPlayerDetails(numberOfPlayers);
            for (int i = 0; i < numberOfPlayers; i++) {
                hangman.playHangman(i);
            }
            hangman.leaderBoard();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
