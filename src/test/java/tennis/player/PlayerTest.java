package tennis.player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setup() {
        player = new Player("Player 1");
    }

    @Test
    public void currentGameScore_should_be_0_when_the_player_has_not_scored_yet() {
        assertEquals("0", player.getCurrentGameScore());
    }

    @Test
    public void currentGameScore_should_be_15_when_the_player_score_once() {

        // When
        player.score();

        // Then
        assertEquals("15", player.getCurrentGameScore());
    }

    @Test
    public void currentGameScore_should_be_30_when_the_player_score_twice() {

        // When
        player.score();
        player.score();

        // Then
        assertEquals("30", player.getCurrentGameScore());
    }

    @Test
    public void currentGameScore_should_be_40_when_the_player_score_three_times() {

        // When
        player.score();
        player.score();
        player.score();

        // Then
        assertEquals("40", player.getCurrentGameScore());
    }

    @Test
    public void currentGameScore_should_be_Advanatage_when_the_player_score_four_times() {

        // When
        player.score();
        player.score();
        player.score();
        player.score();

        // Then
        assertEquals("ADVANTAGE", player.getCurrentGameScore());
    }

    @Test
    public void player_1_should_have_advanatage_compared_to_the_other_player() {

        // Given
        Player otherPlayer = new Player("Other Player");

        // When
        otherPlayer.score();
        otherPlayer.score();
        otherPlayer.score();

        player.score();
        player.score();
        player.score();
        player.score();

        // Then
        assertEquals(Boolean.TRUE, player.hasAdvantageComparedTo(otherPlayer));
    }

}