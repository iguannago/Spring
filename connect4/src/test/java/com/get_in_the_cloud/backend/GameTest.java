package com.get_in_the_cloud.backend;

import junitparams.JUnitParamsRunner;
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

    @Test
    public void gameIsStarted() {
        Game game = Game.of(player1, player2);
        assertNotNull(game);
    }

    @Test
    public void player1DropDiscOnANonFullColumn() {
        Game game = Game.of(player1, player2);
        game.dropDisc(player1);
        assertEquals(PlayerColours.RED, game.getGameBoard()[0][5]);
    }


}
