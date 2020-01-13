package tennis.player;

import java.util.Objects;

public class Player {

    private String name;
    private String currentGameScore;
    private int wonSets;
    private int tieBreakGame;

    public Player(String name) {
        this.name = name;
        this.currentGameScore = "0";
        this.wonSets = 0;
        this.tieBreakGame = 0;
    }

    public boolean hasAdvantageComparedTo(Player otherPlayer) {
        return Objects.equals(this.getCurrentGameScore(), "ADVANTAGE") &&
                Objects.equals(otherPlayer.getCurrentGameScore(), "40");
    }

    public void score(){
        switch (currentGameScore) {
            case "0":
                currentGameScore = "15";
                break;
            case "15":
                currentGameScore = "30";
                break;
            case "30":
                currentGameScore = "40";
                break;
            case "40":
                currentGameScore = "ADVANTAGE";
                break;
        }
    }

    public String getCurrentGameScore() {
        return currentGameScore;
    }

    public void goBackToDeuce() {
        this.currentGameScore = "40";
    }

    public void initializeCurrentGameScore() {
        this.currentGameScore = "0";
    }

    public int getWonSets() {
        return wonSets;
    }

    public void winNewSet() {
        wonSets++;
    }

    public int getTieBreakGame() {
        return tieBreakGame;
    }

    public void scoreTieBreak() {
        tieBreakGame++;
    }
}
