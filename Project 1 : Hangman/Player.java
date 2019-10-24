public class Player {
    public String name;
    public int score;
    player(final String playerName, final int playerScore) {
        this.name = playerName;
        this.score = playerScore;
    }
    public String getName() {
        return name;
    }
    public void setName(final String playerName) {
        this.name = playerName;
    }
    public String getScore() {
        return score;
    }
    public void setScore(final int playerScore) {
        this.score = playerScore;
    }
    public String toString(){
        return "Player Name : "+this.name+"   "+"score : "+this.score;
    }
}