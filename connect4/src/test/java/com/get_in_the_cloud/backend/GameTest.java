package com.get_in_the_cloud.backend;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 12/01/2017.
 */
public class GameTest {

    @Test
    public void player1StartAGame() throws Exception {
        Player player1 = Player.build("David", PlayerColours.RED);
        Game game = player1.startGame("Computer");
        assertPlayerIsCreatedCorrectly(game.getPlayer1(), "David", PlayerColours.RED);
        assertPlayerIsCreatedCorrectly(game.getPlayer2(), "Computer", PlayerColours.YELLOW);
    }

    private void assertPlayerIsCreatedCorrectly(Player player, String namePlayerExpected,
                                                PlayerColours colourPlayerExpected) {
        System.out.println(player);
        Player playerExpected = Player.build(namePlayerExpected, colourPlayerExpected);
        assertEquals(playerExpected, player);
    }

    @Test
    public void playerDropColourDisc() throws Exception {
//        Player player1 = Player.build("player1", PlayerColours.RED);
//        Game game = player1.startGame("player2");
//        printGameBoard(game.getGameBoard());
//        int column = 1;
//        PlayerColours[][] gameBoard = player1.dropColourDisc(column);
//        assertEquals(PlayerColours.RED, gameBoard[5][0]);
//        printGameBoard(gameBoard);
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
