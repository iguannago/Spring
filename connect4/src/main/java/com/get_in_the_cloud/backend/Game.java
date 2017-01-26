package com.get_in_the_cloud.backend;

/**
 * Created by davicres on 12/01/2017.
 */
final class Game {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private final PlayerColours[][] gameBoard;
    private final Player player1;
    private final Player player2;

    Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameBoard = new PlayerColours[ROWS][COLUMNS];
    }

    PlayerColours[][] getGameBoard() {
        return gameBoard;
    }

    Player getPlayer1() {
        return player1;
    }

    Player getPlayer2() {
        return player2;
    }

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
