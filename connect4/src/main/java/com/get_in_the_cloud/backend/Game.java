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

    public Game playerDropsDiscOnColumn(Player player, int column) {
        return dropDiscRecursive(player, column, GameBoard.ROWS);
    }

    private Game dropDiscRecursive(Player player, int column, int row) {
        PlayerColours cellColour = gameBoard.getCellColourForGivenRowAndColumn(row, column);
        if (cellColour == null) {
            GameBoard nextGameBoard = gameBoard.setColourAt(row, column, player.getColour());
            return new Game(player1, player2, nextGameBoard, workoutOutcome(player, row, column, gameBoard));
        }
        return dropDiscRecursive(player, column, --row);
    }

    private String workoutOutcome(Player player, int row, int column, GameBoard gameBoard) {
        String outcome = "no outcome yet";
        boolean left = workoutOutcomeRecursive(1, "left", player, row, column, gameBoard);
        if (left) {
            outcome = player.getName() + " wins";
        }
        return outcome;
    }

    private boolean workoutOutcomeRecursive(int counter, String move, Player player, int row, int column,
                                            GameBoard gameBoard) {
        PlayerColours cellColour = gameBoard.getCellColourForGivenRowAndColumn(row, column);
        if (player.getColour() == cellColour) {
            counter++;
            if (counter == 4) {
                return true;
            }
            if (move.equals("left")) {
                --column;
                return workoutOutcomeRecursive(counter, move, player, row, column, gameBoard);
            }
            if (move.equals("up") && row == 3) {
                return true;
            }
        }
        return false;
    }

    public String getOutcome() {
        return outcome;
    }
}
