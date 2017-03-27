package com.get_in_the_cloud.backend;

import lombok.Value;

/**
 * Created by davicres on 12/01/2017.
 */
@Value(staticConstructor = "of")
final class Game {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private final PlayerColours[][] gameBoard = new PlayerColours[COLUMNS][ROWS];
    private final Player player1;
    private final Player player2;


    boolean connect4() {
        return false;
    }

    public void dropDisc(Player player, int column) {
        gameBoard[--column][5] = player.getColour();
    }
}
