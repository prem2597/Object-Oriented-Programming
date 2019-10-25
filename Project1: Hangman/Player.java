class Player {
    /**
     * name is the player name.
     */
    private String name;
    /**
     * score is the player score.
    */
    private int score;
    Player(final String playerName1, final int playerScore1) {
        this.name = playerName1;
        this.score = playerScore1;
    }
    public String getPlayerName() {
        return name;
    }
    public void setPlayerName(final String playerName1) {
        this.name = playerName1;
    }
    public int getPlayerScore() {
        return score;
    }
    public void setPlayerScore(final int playerScore1) {
        this.score = playerScore1;
    }
}
