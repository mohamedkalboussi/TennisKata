package tennis;

import tennis.player.Player;
import tennis.set.Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Match {

    private Player playerOne;
    private Player playerTwo;
    private List<Set> sets;
    private Set currentSet;

    public Match(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentSet = new Set();
        this.sets = new ArrayList<>(Collections.singletonList(currentSet));
    }

    public String getScore() {
        return sets.stream()
                .map(Set::getScore)
                .collect(Collectors.joining(" "));
    }

    public String getCurrentGameStatus() {
        if (isDeuce()) {
            return "Deuce";
        }
        if (playerOne.hasAdvantageComparedTo(playerTwo)) {
            return "Advantage for Player 1";
        }
        if (playerTwo.hasAdvantageComparedTo(playerOne)) {
            return "Advantage for Player 2";
        }
        return playerOne.getCurrentGameScore() + "-" + playerTwo.getCurrentGameScore();
    }

    private boolean isDeuce() {
        return Objects.equals(playerOne.getCurrentGameScore(), "40")
                && Objects.equals(playerTwo.getCurrentGameScore(), "40");
    }

    public String getMatchStatus() {
        if (playerOne.getWonSets() == 3) {
            return "Player 1 win";
        }
        if (playerTwo.getWonSets() == 3) {
            return "Player 2 win";
        }
        return "In Progress";
    }

    public void playerOneScore() {
        final String currentGameStatus = getCurrentGameStatus();

        playerOne.score();

        if (Objects.equals(currentGameStatus, "Advantage for Player 1")
                || Objects.equals(currentGameStatus, "40-0") || Objects.equals(currentGameStatus, "40-15") || Objects.equals(currentGameStatus, "40-30")) {
            // playerOne win the current game
            playerOneWinGame();
        }
        if (Objects.equals(currentGameStatus, "Advantage for Player 2")) {
            // go back to Deuce
            playerOne.goBackToDeuce();
            playerTwo.goBackToDeuce();
        }
    }

    private void playerOneWinGame() {
        currentSet.increaseWonGamesForPlayerOne();

        if (currentSet.getWonGamesForPlayerOne() >= 6 && (currentSet.getWonGamesForPlayerOne() - currentSet.getWonGamesForPlayerTwo()) >= 2) {
            playerOneWinSet();
        }
        // finally, initialize the current game score for the two players
        playerOne.initializeCurrentGameScore();
        playerTwo.initializeCurrentGameScore();
    }

    public void playerOneWinSet() {
        // increase the number of the won sets for Player 1
        playerOne.winNewSet();
        // then, add this set to the list of the match sets
        if (sets.size() < 3) {
            currentSet = new Set();
            sets.add(currentSet);
        }
    }

    public void playerTwoScore() {
        final String currentGameStatus = getCurrentGameStatus();

        playerTwo.score();

        if (Objects.equals(currentGameStatus, "Advantage for Player 2")
                || Objects.equals(currentGameStatus, "0-40") || Objects.equals(currentGameStatus, "15-40") || Objects.equals(currentGameStatus, "30-40")) {
            // playerTwo win the current game
            playerTwoWinGame();
        }
        if (Objects.equals(currentGameStatus, "Advantage for Player 1")) {
            // go back to Deuce
            playerOne.goBackToDeuce();
            playerTwo.goBackToDeuce();
        }
    }

    private void playerTwoWinGame() {
        currentSet.increaseWonGamesForPlayerTwo();

        if (currentSet.getWonGamesForPlayerTwo() >= 6 && (currentSet.getWonGamesForPlayerTwo() - currentSet.getWonGamesForPlayerOne()) >= 2) {
            playerTwoWinSet();
        }
        // finally, initialize the current game score for the two players
        playerOne.initializeCurrentGameScore();
        playerTwo.initializeCurrentGameScore();
    }

    private void playerTwoWinSet() {
        // increase the number of the won sets for Player 2
        playerTwo.winNewSet();
        // then, add this set to the list of the match sets
        if (sets.size() < 3) {
            currentSet = new Set();
            sets.add(currentSet);
        }
    }

    public void playerOneScoreTieBreak() {
        if (currentSet.getWonGamesForPlayerOne() == 6 && currentSet.getWonGamesForPlayerTwo() == 6) {
            playerOne.scoreTieBreak();
            if (playerOne.getTieBreakGame() >= 7 && (playerOne.getTieBreakGame() - playerTwo.getTieBreakGame()) >= 2) {
                currentSet.increaseWonGamesForPlayerOne();
                playerOneWinSet();
            }
        }
    }

    public void playerTwoScoreTieBreak() {
        if (currentSet.getWonGamesForPlayerTwo() == 6 && currentSet.getWonGamesForPlayerOne() == 6) {
            playerTwo.scoreTieBreak();
            if (playerTwo.getTieBreakGame() >= 7 && (playerTwo.getTieBreakGame() - playerOne.getTieBreakGame()) >= 2) {
                currentSet.increaseWonGamesForPlayerTwo();
                playerTwoWinSet();
            }
        }
    }
}
