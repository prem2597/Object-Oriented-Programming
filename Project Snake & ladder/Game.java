import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author PREM
 */
class Game {
    private int[][] board;
    private Player[] players;
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;

    Game (final int numberOfPlayers) {
        final int maxLen = 10;
        board = new int[maxLen][maxLen];
        players = new Player[numberOfPlayers];
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
    }
    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(final Player[] players1) {
        this.players = players1;
    }
    public int[][] getBoard() {
        return board;
    }

    public void setBoard(final int[][] board1) {
        this.board = board1;
    }

    public ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(final ArrayList<Snake> snakes1) {
        this.snakes = snakes1;
    }

    public ArrayList<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(final ArrayList<Ladder> ladders1) {
        this.ladders = ladders1;
    }

    void createSnakes() {
        // final int[] snakeStart = {43, 55, 70, 78, 95, 96};
        // final int[] snakeEnd = {16, 34, 48, 42, 73, 82};
        final int[] snakeStart= {};
        final int[] snakeEnd = {};
        int numOfSnakes = snakeStart.length;
        for (int i = 0; i < numOfSnakes; i++) {
            snakes.add(new Snake(snakeStart[i], snakeEnd[i]));
        }
    }

    void createLadders() {
        // final int[] ladderStart = {6, 9, 20, 25, 53, 54, 61};
        // final int[] ladderEnd = {27, 50, 39, 57, 72, 85, 82};
        final int[] ladderStart = {};
        final int[] ladderEnd = {};
        int numOfLadders = ladderEnd.length;
        for (int i = 0; i < numOfLadders; i++) {
            ladders.add(new Ladder(ladderStart[i], ladderEnd[i]));
        }
    }

    public void getDetails(final int numberOfPlayers) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(" player " + (i + 1) + " name ");
            String name = scan.next();
            Player temp = new Player(name, 0, 0, false);
            this.players[i] = temp;
        }
    }
    void createGame() {
        this.createSnakes();
        this.createLadders();
        final int snake = 1;
        final int ladder = 2;
        final int maxLen = 10;
        for (int i = 0; i < this.snakes.size(); i++) {
            int n = this.snakes.get(i).getStart();
            int r = n / maxLen;
            int c = n % maxLen;
            this.board[r][c] = snake;
        }

        for (int i = 0; i < this.ladders.size(); i++) {
            int n = this.ladders.get(i).getStart();
            int r = n / maxLen;
            int c = n % maxLen;
            this.board[r][c] = ladder;
        }
    }

    public int getLadderEnd(final int ladderStart) {
        int ladderEnd = -1;
        for (int i = 0; i < ladders.size(); i++) {
            if (ladderStart == ladders.get(i).getStart()) {
                ladderEnd = ladders.get(i).getEnd();
                break;
            }
        }
        return ladderEnd;
    }

    public int getSnakeEnd(final int snakeStart) {
        int snakeEnd = 0;
        for (int i = 0; i < snakes.size(); i++) {
            if (snakeStart == snakes.get(i).getStart()) {
                snakeEnd = snakes.get(i).getEnd();
            }
        }
        return snakeEnd;
    }

    void printCurrentPostion(final int i) {
        System.out.println(" Present postion of "
                + this.getPlayers()[i].getPlayerName() + " is "
                + this.getPlayers()[i].getPlayerPosition());
    }

    boolean checkIsWinner(final int i) {
        return this.getPlayers()[i].isGameWon();
    }

    void increaseChances(final int i) {
        System.out.println("chance of player = "
            + this.getPlayers()[i].getPlayerName());
        this.getPlayers()[i].setNumberOfChances(
            this.getPlayers()[i].getNumberOfChances() + 1);
    }

    int getCurrentPosition(final int i) {
        return this.getPlayers()[i].getPlayerPosition();
    }

    int rollDice() {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("enter something to roll");
        // sc.nextLine();
        final int maxOnDice = 6;
        int valueOnDice = (int) ((Math.random() * maxOnDice) + 1);
        System.out.println(" value on dice = " + valueOnDice);
        return valueOnDice;
    }

    boolean isValueOnDiceSix(final int valueOnDice) {
        final int maxOnDice = 6;
        if (valueOnDice == maxOnDice) {
            if (isChanceTakenAgain()) {
                return true;
            }
        }
        return false;
    }

    boolean isChanceTakenAgain() {
        // Scanner scan = new Scanner(System.in);
        // System.out.println("do you want to take turn again ?\n YES(Y) or NO(N)");
        // String input = scan.next().toLowerCase();
        // if (input.equals("y") || input.equals("Y")
        // || input.equals("YES") || input.equals("yes")) {
        //     System.out.println("new turn");
        //     return true;
        // }
        return false;
    }

    boolean checkMove(final int curPos, final int i) {
        int tempPos = curPos;
        final int maxVal = 100;
        final int maxLen = 10;
        if (tempPos == maxVal) {
            this.getPlayers()[i].setPlayerPosition(tempPos);
            this.getPlayers()[i].setGameWon(true);
            return true;
        }
        if (tempPos > maxVal) {
            System.out.println("exceeds max postion !!!");
            return false;
        }
        int r = tempPos / maxLen;
        int c = tempPos % maxLen;
        int pos = this.board[r][c];
        switch (pos) {
            case 2:
                tempPos = getLadderEnd(tempPos);
                this.getPlayers()[i].setPlayerPosition(tempPos);
                System.out.println("ladder !!!");
                return true;
            case 1:
                tempPos = getSnakeEnd(tempPos);
                this.getPlayers()[i].setPlayerPosition(tempPos);
                System.out.println("snake !!!");
                return true;
            case 0:
                this.getPlayers()[i].setPlayerPosition(tempPos);
                System.out.println(" Safe Cool !!!");
                return true;
            default:
                break;
        }
        return false;
    }

    void playGame() {
        Scanner scan = new Scanner(System.in);
        int winner = 0;
        int totalPlayers = this.getPlayers().length;
        while (winner != totalPlayers) {
            System.out.println("*****************************");
            for (int i = 0; i < this.getPlayers().length; i++) {
                System.out.println("----------------------------");
                if (checkIsWinner(i)) {
                    continue;
                }
                increaseChances(i);
                boolean stop = true;
                while (stop) {
                    printCurrentPostion(i);
                    int valueOnDice = rollDice();
                    int tempPos = getCurrentPosition(i) + valueOnDice;
                    if (!checkMove(tempPos, i)) {
                        stop = false;
                        continue;
                    } else {
                        if (checkIsWinner(i)) {
                            winner = winner + 1;
                            stop = false;
                        }
                    }
                    stop = isValueOnDiceSix(valueOnDice);
                }
            }
        }
    }
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Snakes & Ladders");
        System.out.println("🐍🐍🐍");
        System.out.println(" Enter the Number of players :");
        boolean check = true;
        int numberOfPlayers = -1;
        while (check) {
            try {
                if (scan.hasNextInt()) {
                    numberOfPlayers = Math.abs(scan.nextInt());
                    if (numberOfPlayers < 1) {
                        throw new Exception();
                    }
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(" Wrong Input ");
                System.out.println("Enter a positive numeral only...");
                scan.next();
            }
        }

        Game play = new Game(numberOfPlayers);
        play.getDetails(numberOfPlayers);
        play.createGame();
        play.playGame();
        Player[] players = play.getPlayers();
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = 0; j < players.length - i - 1; j++) {
                if (players[j].getNumberOfChances()
                    >
                    players[j + 1].getNumberOfChances()) {
                    Player temp = players[j];
                    players[j] = players[j + 1];
                    players[j + 1] = temp;
                }
            }
        }
        System.out.println("Congratualtions..!!!");
        System.out.println(" total number of chances taken for winning ");
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(" name = " + players[i].getPlayerName()
            + " " + " chances = " + players[i].getNumberOfChances());
        }
        // System.out.println("Congratulations Mr." + players[i].getPlayerName());
    }
}
