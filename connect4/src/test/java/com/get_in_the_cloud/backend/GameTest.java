package com.get_in_the_cloud.backend;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 12/01/2017.
 */
@RunWith(JUnitParamsRunner.class)
public class GameTest {

    private final Player player1 = Player.of("Player1", PlayerColours.RED);
    private final Player player2 = Player.of("Player2", PlayerColours.YELLOW);
    private final Game game = Game.of(new PlayerColours[7][6], player1, player2, "no outcome yet");

    @Test
    public void gameIsStarted() {
        assertNotNull(game);
        assertNotNull(player1);
        assertNotNull(player2);
        assertNotNull(game.getGameBoard());
        assertEquals("no outcome yet", game.getOutcome());
    }

    @Test
    @Parameters({"1", "2", "3", "4", "5", "6", "7"})
    public void playerDropDiscOnANonFullColumn(int column) {
        Game game = this.game.dropDisc(player1, column);
        assertEquals(PlayerColours.RED, game.getGameBoard()[--column][5]);
    }

    @Test
    public void player1WinsGame() throws Exception {
        int column = 1;
        Game game = this.game.dropDisc(player1, column);
        assertEquals(PlayerColours.RED, game.getGameBoard()[0][5]);
        assertEquals("no outcome yet", game.getOutcome());


    }
}
