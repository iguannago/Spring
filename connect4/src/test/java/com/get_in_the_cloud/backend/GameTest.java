package com.get_in_the_cloud.backend;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 12/01/2017.
 */
public class GameTest {

    private final Player player1 = Player.build("player1", "RED");
    private final Game game = player1.startGame("player2");

    @Test
    public void playerStartAGame() throws Exception {
        assertNotNull(game);
    }

    @Test
    public void playerDropColourDisc() throws Exception {
        boolean[][] gameBoard = new boolean[6][7];
        printGameBoard(gameBoard);
        int column = 1;
//        gameBoard = player1.dropColourDisc(gameBoard, column);
//        assertEquals(true, gameBoard[5][0]);
    }

    private void printGameBoard(boolean[][] gameBoard) {
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
