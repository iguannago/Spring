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

    void dropColourDisc(Player player, int column) {
        if (column - 1 > COLUMNS) {
            throw new ArrayIndexOutOfBoundsException("Column Number is Incorrect");
        }
        if (gameBoard[ROWS - 1][column - 1] == null) {
            gameBoard[ROWS - 1][column - 1] = player.getColour();
        } else {
            gameBoard[ROWS - 2][column - 1] = player.getColour();
        }
    }

    boolean connect4() {
        return false;
    }
}
