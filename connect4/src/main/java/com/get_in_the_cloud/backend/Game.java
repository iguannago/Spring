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
        this.gameBoard = new PlayerColours[7][6];
    }

    PlayerColours[][] getGameBoard() {
        return gameBoard;
    }

    Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
