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
    private final Game game = Game.of(player1, player2, GameBoard.of(new PlayerColours[6][7]), "no outcome yet");

    @Test
    public void gameIsStarted() {
        assertNotNull(game);
        assertNotNull(player1);
        assertNotNull(player2);
        assertNotNull(game.getGameBoard());
        assertEquals("no outcome yet", game.getOutcome());
    }

    @Test
    public void playerDropsDiscOnANonFullColumn() {
        int discDropTimes = 7;
        int column = 1;
        int row = 6;
        Game finalGame = dropDiscRecursive(discDropTimes, row, column, game);
    }

    private Game dropDiscRecursive(int discDropTimes, int row, int column, Game game) {
        if (discDropTimes == 1) {
            return game;
        }
        Game nextGame = game.dropDisc(player1, column);
        assertEquals(player1.getColour(), nextGame.getGameBoard().getColourAt(row, column));
        return dropDiscRecursive(--discDropTimes, --row, column, nextGame);
    }

    @Test
    public void playerDropsDisc4TimesOnColumnToWinGame() throws Exception {
        int column = 1;
        int row = 6;
        int count = 1;
        Game finalGame = playerDropsDisc4TimesRecursive(count, column, row, game);
        assertEquals("Player1 wins", finalGame.getOutcome());
    }

    private Game playerDropsDisc4TimesRecursive(int count, int column, int row, Game game) {
        if (count > 4) {
            return game;
        }
        Game nextGame = game.dropDisc(player1, column);
        assertEquals(player1.getColour(), nextGame.getGameBoard().getColourAt(row, column));
        return playerDropsDisc4TimesRecursive(++count, column, --row, nextGame);
    }
}
