package com.get_in_the_cloud.backend;

import lombok.Value;

/**
 * Created by davicres on 12/01/2017.
 */
@Value(staticConstructor = "of")
final class Game {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private final PlayerColours[][] gameBoard;
    private final Player player1;
    private final Player player2;
    private final String outcome;


    public Game dropDisc(Player player, int column) {
        PlayerColours[][] gameBoard = new PlayerColours[COLUMNS][ROWS];
        gameBoard[--column][ROWS - 1] = player.getColour();
        return new Game(gameBoard, player1, player2, "no outcome yet");
    }

    public String getOutcome() {
        return outcome;
    }
}
