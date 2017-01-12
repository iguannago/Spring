package com.get_in_the_cloud.backend;

/**
 * Created by davicres on 12/01/2017.
 */
final class Player {
    private final String name;
    private final String colour;

    private Player(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    static Player build(String name, String colour) {
        return new Player(name, colour);
    }

    String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public Game startGame(String player2) {
        return new Game();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
