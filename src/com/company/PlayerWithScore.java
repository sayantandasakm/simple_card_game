package src.com.company;

public class PlayerWithScore {
    private Player player;
    private int score;

    public PlayerWithScore() {
    }

    public PlayerWithScore(Player player, int score) {
        this.player = player;
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
