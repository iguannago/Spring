package com.get_in_the_cloud.backend;

/**
 * Created by davicres on 12/01/2017.
 */
final class Game {
    private PlayerColours[][] gameBoard = new PlayerColours[6][7];

    PlayerColours[][] getGameBoard() {
        return gameBoard;
    }
}
