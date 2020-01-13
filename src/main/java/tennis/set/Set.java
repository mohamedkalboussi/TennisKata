package tennis.set;

public class Set {

    private int wonGamesForPlayerOne;
    private int wonGamesForPlayerTwo;

    public Set() {
        this.wonGamesForPlayerOne = 0;
        this.wonGamesForPlayerTwo = 0;
    }

    public Set(int wonGamesForPlayerOne, int wonGamesForPlayerTwo) {
        this.wonGamesForPlayerOne = wonGamesForPlayerOne;
        this.wonGamesForPlayerTwo = wonGamesForPlayerTwo;
    }

    public static String getScore(Set set) {
        final StringBuilder sb = new StringBuilder();
        sb
                .append("(")
                .append(set.getWonGamesForPlayerOne())
                .append("-")
                .append(set.getWonGamesForPlayerTwo())
                .append(")");
        return sb.toString();
    }

    public int getWonGamesForPlayerOne() {
        return wonGamesForPlayerOne;
    }

    public void increaseWonGamesForPlayerOne() {
        this.wonGamesForPlayerOne++;
    }

    public int getWonGamesForPlayerTwo() {
        return wonGamesForPlayerTwo;
    }

    public void increaseWonGamesForPlayerTwo() {
        this.wonGamesForPlayerTwo++;
    }
}
