import java.util.*;
/**
 * @author Prem
 */
class Player {
    /**
     * player name.
     */
    private String playerName;
    /**
     * number of chances.
     */
    private int numberOfChances;
    /**
     * gamewon or not.
     */
    private boolean gameWon = false;
    /**
     * player position.
     */
    private int playerPosition;

    /**
     * gets the value of player name.
     * @return player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * set the value of playername.
     * @param playerName1
     */
    public void setPlayerName(final String playerName1) {
        this.playerName = playerName1;
    }

    /**
     * number of chances.
     * @return number of chances
     */
    public int getNumberOfChances() {
        return numberOfChances;
    }

    public void setNumberOfChances(final int numberOfChances1) {
        this.numberOfChances = numberOfChances1;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(final boolean gameWon1) {
        this.gameWon = gameWon1;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(final int playerPosition1) {
        this.playerPosition = playerPosition1;
    }

    Player (final String playerName1, final int playerPosition1,
        final int numberOfChances1, final boolean gameWon1) {
            this.playerName = playerName1;
            this.numberOfChances = numberOfChances1;
            this.gameWon = gameWon1;
            this.playerPosition = playerPosition1;

        }
}