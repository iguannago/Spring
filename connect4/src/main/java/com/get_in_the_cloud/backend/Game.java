package com.get_in_the_cloud.backend;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

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
            return new Game(player1, player2, nextGameBoard, workoutOutcome(player1, row, column, gameBoard));
        }
        return dropDiscRecursive(player, column, --row);
    }

    private String workoutOutcome(Player player, int row, int column, GameBoard gameBoard) {
        int counter = 1;
        List<String> movements = new ArrayList<>(2);
        movements.add("left");
        movements.add("up");
        String outcome = "no yet outcome";
        for (String move : movements) {
            if (move.equals("left") && column >= 4) {
                --column;
                outcome = workoutOutcomeRecursive(counter, move, player, row, column, gameBoard);
            }
            if (move.equals("up") && row >= 4) {
                --row;
                outcome = workoutOutcomeRecursive(counter, move, player, row, column, gameBoard);
            }
            if (outcome.equals(player.getName() + " wins")) {
                return outcome;
            }
        }
        return outcome;
    }

    private String workoutOutcomeRecursive(int counter, String move, Player player, int row, int column,
                                           GameBoard gameBoard) {
        PlayerColours cellColour = gameBoard.getCellColourForGivenRowAndColumn(row, column);
        if (player.getColour() == cellColour) {
            counter++;
            if (counter == 4) {
                return player.getName() + " wins";
            }
            if (move.equals("left")) {
                --column;
                return workoutOutcomeRecursive(counter, move, player, row, column, gameBoard);
            }
            if (move.equals("up") && row == 3) {
                return player.getName() + " wins";
            }
        }
        return "no outcome yet";
    }

    public String getOutcome() {
        return outcome;
    }
}
