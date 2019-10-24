import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public final class Main {
    private Main() {
    }
    private static String[] readFile(final String fileName)
    throws FileNotFoundException
    {
    try {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        ArrayList<String> lines = new ArrayList<String>();
        while (scan.hasNextLine())
        {
            String temp = scan.nextLine();
            if (temp.length() != 0) {
                lines.add(temp);
            }
        }
        String[] fileContents = lines.toArray(new String[lines.size()]);
        return fileContents;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(" enter the number of players ");
        int numberOfPlayers = 2 + 2;
        Scanner sc = new Scanner(System.in);
        try {
            if (sc.hasNext()) {
                numberOfPlayers = sc.nextInt();
            }
        } catch (InputMismatchException is) {
            System.out.println("wrong input...default number of players is 4 ");
        }
        try {
            System.out.println(" number of players " + numberOfPlayers);
            String[] fileContents = readFile("movies.txt");
            if (fileContents == null) {
                throw new NullPointerException();
            }
            Hangman hangman = new Hangman(numberOfPlayers);
            hangman.setDetails(fileContents);
            hangman.readPlayerDetails(numberOfPlayers);
            for (int current = 0; current < numberOfPlayers; current++) {
                hangman.playHangman(current);
            }
            hangman.leaderBoard();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}