package com.get_in_the_cloud.backend;

/**
 * Created by davicres on 12/01/2017.
 */
final class Player {
    private final String name;

    private Player(String name) {
        this.name = name;
    }

    static Player build(String name) {
        return new Player(name);
    }

    String getName() {
        return name;
    }

    public Game startGame(String player2) {
        return new Game();
    }
}
