package com.get_in_the_cloud.backend;

/**
 * Created by davicres on 12/01/2017.
 */
final class Game {
    private final PlayerColours[][] gameBoard;
    private final Player player1;
    private final Player player2;

    Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameBoard = new PlayerColours[6][7];
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
        if (column == 1) {
            gameBoard[5][0] = player.getColour();
        }
        if (column == 2) {
            gameBoard[5][1] = player.getColour();
        }
        if (column == 3) {
            gameBoard[5][2] = player.getColour();
        }
    }

    boolean connect4() {
        return false;
    }
}
