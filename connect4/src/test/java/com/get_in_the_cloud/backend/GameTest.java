package com.get_in_the_cloud.backend;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 12/01/2017.
 */
public class GameTest {

    private final Player player1 = Player.build("David", PlayerColours.RED);
    private final Game game = player1.startGame("Computer");

    @Test
    public void player1StartAGame() throws Exception {
        assertPlayerIsCreatedCorrectly(game.getPlayer1(), "David", PlayerColours.RED);
        assertPlayerIsCreatedCorrectly(game.getPlayer2(), "Computer", PlayerColours.YELLOW);
        assertNotNull(game.getGameBoard());
    }

    private void assertPlayerIsCreatedCorrectly(Player player, String namePlayerExpected,
                                                PlayerColours colourPlayerExpected) {
        System.out.println(player);
        Player playerExpected = Player.build(namePlayerExpected, colourPlayerExpected);
        assertEquals(playerExpected, player);
    }

    @Test
    public void playerDropColourDisc() throws Exception {
        game.dropColourDisc(game.getPlayer1(), 1);
        printGameBoard(game.getGameBoard());
        PlayerColours actualColour = game.getGameBoard()[5][0];
        assertEquals(PlayerColours.RED.name(), actualColour.name());
        game.dropColourDisc(game.getPlayer1(), 2);
        actualColour = game.getGameBoard()[5][1];
        assertEquals(PlayerColours.RED.name(), actualColour.name());
    }

    @Test
    public void player1WinsPlayer2() throws Exception {
        game.dropColourDisc(player1, 1);
        assertEquals(PlayerColours.RED.name(), game.getGameBoard()[5][0].name());
        printGameBoard(game.getGameBoard());
//        game.dropColourDisc(game.getPlayer2(), 2);
        boolean result = game.connect4();
        assertEquals(false, result);
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
