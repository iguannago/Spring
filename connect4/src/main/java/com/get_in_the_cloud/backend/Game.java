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
        return dropDiscRecursive(player, column, ROWS);
    }

    private Game dropDiscRecursive(Player player, int column, int row) {
        PlayerColours cell = gameBoard[row - 1][column - 1];
        if (cell == null) {
            PlayerColours[][] newGameBoard = gameBoard.clone();
            newGameBoard[row - 1][column - 1] = player.getColour();
            return new Game(newGameBoard, player1, player2, workOutOutcome(player1, row));
        }
        return dropDiscRecursive(player, column, --row);
    }

    private String workOutOutcome(Player player, int row) {
        if (row == 3) {
            return player.getName() + " wins";
        }
        return "no outcome yet";
    }

    public String getOutcome() {
        return outcome;
    }
}
