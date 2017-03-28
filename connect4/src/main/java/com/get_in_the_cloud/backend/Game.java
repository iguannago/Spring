package com.get_in_the_cloud.backend;

import lombok.Value;

/**
 * Created by davicres on 12/01/2017.
 */
@Value(staticConstructor = "of")
final class Game {
    private final Player player1;
    private final Player player2;
    private final GameBoard gameBoard;
    private final String outcome;

    public Game dropDisc(Player player, int column) {
        return dropDiscRecursive(player, column, GameBoard.ROWS);
    }

    private Game dropDiscRecursive(Player player, int column, int row) {
        PlayerColours colourAt = gameBoard.getColourAt(row, column);
        if (colourAt == null) {
            GameBoard nextGameBoard = gameBoard.setColourAt(row, column, player.getColour());
            return new Game(player1, player2, nextGameBoard, workOutOutcome(player1, row, column, gameBoard));
        }
        return dropDiscRecursive(player, column, --row);
    }

    private String workOutOutcome(Player player, int row, int column, GameBoard gameBoard) {
        if (row == 3) {
            return player.getName() + " wins";
        }
        return "no outcome yet";
    }

    public String getOutcome() {
        return outcome;
    }
}
