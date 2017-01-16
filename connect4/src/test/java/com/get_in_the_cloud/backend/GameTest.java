package com.get_in_the_cloud.backend;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 12/01/2017.
 */
public class GameTest {

    private final Player player1 = Player.build("player1", PlayerColours.RED);
    private final Game game = player1.startGame("player2");

    @Test
    public void playerStartAGame() throws Exception {
        assertNotNull(game);
        PlayerColours[][] gameBoard = game.getGameBoard();
    }

    @Test
    public void playerDropColourDisc() throws Exception {
        printGameBoard(game.getGameBoard());
        int column = 1;
        PlayerColours[][] gameBoard = player1.dropColourDisc(column);
        assertEquals(PlayerColours.RED, gameBoard[5][0]);
        printGameBoard(gameBoard);
    }

    private void printGameBoard(PlayerColours[][] gameBoard) {
        System.out.println("gameBoard: ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("(" + i + "," + j + "):" + gameBoard[i][j] + " ");
                if (j == 6) {
                    System.out.println();
                }
            }
        }
    }
}
