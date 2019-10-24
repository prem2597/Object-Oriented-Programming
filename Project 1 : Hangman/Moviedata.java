import java.io.File;
import java.util.Scanner;
import java.util.ArrayyList;
import java.util.FileNotFoundException;
import java.util.InputMismatchException;
public class Moviedata {
    Moviedata() {
    }
    public static String[] file(final String fileName) throws FileNotFoundException {
        try 
        {
            File readFile = new File(fileName);
            Scanner sc = new Scanner(readFile);
            ArrayList<String> lines = new ArrayList<String>();
            while(sc.hasNextLine())
            {
                String data = scan.nextLine();
                if (data.length()!=0) {
                    lines.add(data);
                }
            }
            String dataArray[] = data.toArray(new String[data.size()]);
            return dataArray;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(sc != null) {
                sc.close();
            }
        }
        return null;
    public static void main(final String[] args)
    {
        System.out.println(" enter the number of players ");
        int numberOfPlayers = 4;
        Scanner sc = new Scanner(System.in);
        try {
            if (sc.hasNext()) {
                numberOfPlayers = sc.nextInt();
            }
        }
        catch (InputMismatchException is)
        {
            System.out.println("wrong input...default number of players is 4 ");
        }
        try
        {
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
        } 
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}