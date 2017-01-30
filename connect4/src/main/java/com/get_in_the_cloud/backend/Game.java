package com.get_in_the_cloud.backend;

import lombok.Builder;
import lombok.Value;

/**
 * Created by davicres on 12/01/2017.
 */
@Value
@Builder
final class Game {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private final PlayerColours[][] gameBoard = new PlayerColours[ROWS][COLUMNS];
    private final Player player1;
    private final Player player2;

    PlayerColours dropColourDisc(Player player, int column) {
        System.out.println("dropColourDisc:");
        System.out.println(player);
        System.out.println("column: " + column);
        if (gameBoard[ROWS - 1][column - 1] == null) {
            return gameBoard[ROWS - 1][column - 1] = player.getColour();
        }
        return null;
    }

    boolean connect4() {
        return false;
    }
}
