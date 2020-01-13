package tennis;

import tennis.player.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatchTest {

    private Player playerOne;
    private Player playerTwo;
    private Match match;

    @Before
    public void setup() {
        playerOne = new Player("PlayerOne");
        playerTwo = new Player("PlayerTwo");
        match = new Match(playerOne, playerTwo);
    }

    @Test
    public void tennis_match_should_start_with_score_of_0_0() {
        assertEquals("(0-0)", match.getScore());
    }

    @Test
    public void tennis_match_should_start_with_current_game_status_of_0_0() {
        assertEquals("0-0", match.getCurrentGameStatus());
    }

    @Test
    public void tennis_match_should_start_with_match_status_of_in_progress() {
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_15_0_when_playerOne_scores(){

        // When
        match.playerOneScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("15-0", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_0_15_when_playerTwo_scores(){

        // When
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("0-15", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_15_15_when_playerOne_scores_and_playerTwo_scores(){

        // When
        match.playerOneScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("15-15", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_0_30(){

        // When
        match.playerTwoScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("0-30", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_0_40(){

        // When
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("0-40", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_15_30(){

        // When
        match.playerOneScore();
        match.playerTwoScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("15-30", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_15_40(){

        // When
        match.playerOneScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("15-40", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_30_0(){

        // When
        match.playerOneScore();
        match.playerOneScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("30-0", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_30_15(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("30-15", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_30_30(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerTwoScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("30-30", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_30_40(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("30-40", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_40_0(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("40-0", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_40_15(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("40-15", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_40_30(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerTwoScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("40-30", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_Deuce(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("Deuce", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_Advantage_for_player_1(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerOneScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("Advantage for Player 1", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_Advantage_for_player_2(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("Advantage for Player 2", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_Deuce_when_playerOne_lost_the_advantage(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerOneScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("Deuce", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_current_game_status_of_Deuce_when_playerTwo_lost_the_advantage(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerOneScore();

        // Then
        assertEquals("(0-0)", match.getScore() );
        assertEquals("Deuce", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_score_of_1_0_when_playerOne_win_the_game(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        // Then
        assertEquals("(1-0)", match.getScore() );
        assertEquals("0-0", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_score_of_1_1_when_playerOne_win_a_game_and_playerTwo_win_a_game(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        // Then
        assertEquals("(1-1)", match.getScore() );
        assertEquals("0-0", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_score_of_6_0_when_playerOne_win_6_games_and_playerTwo_win_0_games(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        // Then
        assertEquals("(6-0) (0-0)", match.getScore() );
        assertEquals("0-0", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_score_of_6_6_when_playerOne_win_6_games_and_playerTwo_win_6_games(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        // Then
        assertEquals("(6-6)", match.getScore() );
        assertEquals("0-0", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_score_of_7_6_when_playerOne_win_6_games_and_playerTwo_win_6_games_and_playerOne_win_the_tie_break(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        // here, playerOne score 7 tie break
        match.playerOneScoreTieBreak();
        match.playerOneScoreTieBreak();
        match.playerOneScoreTieBreak();
        match.playerOneScoreTieBreak();
        match.playerOneScoreTieBreak();
        match.playerOneScoreTieBreak();
        match.playerOneScoreTieBreak();
        // and, playerOne score 1 tie break
        match.playerTwoScoreTieBreak();

        // Then
        assertEquals("(7-6) (0-0)", match.getScore() );
        assertEquals("0-0", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_be_with_score_of_6_7_when_playerOne_win_6_games_and_playerTwo_win_6_games_and_playerTwo_win_the_tie_break(){

        // When
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        // here, playerOne score 6 tie break
        match.playerOneScoreTieBreak();
        match.playerOneScoreTieBreak();
        match.playerOneScoreTieBreak();
        match.playerOneScoreTieBreak();
        match.playerOneScoreTieBreak();
        match.playerOneScoreTieBreak();
        // and, playerOne score 8 tie break
        match.playerTwoScoreTieBreak();
        match.playerTwoScoreTieBreak();
        match.playerTwoScoreTieBreak();
        match.playerTwoScoreTieBreak();
        match.playerTwoScoreTieBreak();
        match.playerTwoScoreTieBreak();
        match.playerTwoScoreTieBreak();
        match.playerTwoScoreTieBreak();

        // Then
        assertEquals("(6-7) (0-0)", match.getScore() );
        assertEquals("0-0", match.getCurrentGameStatus());
        assertEquals("In Progress", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_finish_with_match_status_of_Player_1_win_when_playerOne_win_3_sets_and_playerTwo_win_0_sets(){

        // When
        // playerOne win the first set
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        // And
        // playerOne win the second set
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        // And
        // playerOne win the third set
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();
        match.playerOneScore();

        // Then
        assertEquals("(6-0) (6-0) (6-0)", match.getScore() );
        assertEquals("0-0", match.getCurrentGameStatus());
        assertEquals("Player 1 win", match.getMatchStatus());
    }

    @Test
    public void tennis_match_should_finish_with_match_status_of_Player_2_win_when_playerOne_win_0_sets_and_playerTwo_win_3_sets(){

        // When
        // playerTwo win the first set
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        // And
        // playerTwo win the second set
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        // And
        // playerTwo win the third set
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();
        match.playerTwoScore();

        // Then
        assertEquals("(0-6) (0-6) (0-6)", match.getScore() );
        assertEquals("0-0", match.getCurrentGameStatus());
        assertEquals("Player 2 win", match.getMatchStatus());
    }
}
