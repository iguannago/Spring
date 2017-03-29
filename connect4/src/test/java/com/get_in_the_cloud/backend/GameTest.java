package com.get_in_the_cloud.backend;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 12/01/2017.
 */
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
        int discDropTimes = 1;
        int column = 1;
        int row = 6;
        dropDiscRecursive(discDropTimes, row, column, game);
    }

    private Game dropDiscRecursive(int discDropTimes, int row, int column, Game game) {
        if (discDropTimes == 7) {
            return game;
        }
        Game nextGame = game.playerDropsDiscOnColumn(player1, column);
        assertEquals(player1.getColour(), nextGame.getGameBoard().getCellColourForGivenRowAndColumn(row, column));
        return dropDiscRecursive(++discDropTimes, --row, column, nextGame);
    }

    @Test
    @Ignore
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
        Game nextGame = game.playerDropsDiscOnColumn(player1, column);
        assertEquals(player1.getColour(), nextGame.getGameBoard().getCellColourForGivenRowAndColumn(row, column));
        return playerDropsDisc4TimesRecursive(++count, column, --row, nextGame);
    }

    @Test
    public void playerDropsDiscToWinGameWith4DiscsHorizontally() throws Exception {
        Game givenGame = givenStartedGameWith3RedDiscsHorizontallyInLine();
        Game nextGame = givenGame.playerDropsDiscOnColumn(player1, 4);
        assertEquals("Player1 wins", nextGame.getOutcome());
    }

    private Game givenStartedGameWith3RedDiscsHorizontallyInLine() {
        PlayerColours[][] board = new PlayerColours[6][7];
        board[5][0] = PlayerColours.RED;
        board[5][1] = PlayerColours.RED;
        board[5][2] = PlayerColours.RED;
        GameBoard gameBoard = GameBoard.of(board);
        return Game.of(player1, player2, gameBoard, "no outcome yet");
    }
}
