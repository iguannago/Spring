package com.get_in_the_cloud.backend;

/**
 * Created by davicres on 12/01/2017.
 */
final class Player {
    private final String name;
    private final PlayerColours colour;

    private Player(String name, PlayerColours colour) {
        this.name = name;
        this.colour = colour;
    }

    static Player build(String name, PlayerColours colour) {
        return new Player(name, colour);
    }

    String getName() {
        return name;
    }

    PlayerColours getColour() {
        return colour;
    }

    Game startGame(String player2) {
        return new Game();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", colour=" + colour +
                '}';
    }
}
