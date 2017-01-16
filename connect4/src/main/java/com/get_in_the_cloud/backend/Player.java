package com.get_in_the_cloud.backend;

/**
 * Created by davicres on 12/01/2017.
 */
final class Player {
    private final String name;
    private final PlayerColours colour;
    private  Game game;

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

    Game startGame(String player2Name) {
        Player player2 = Player.build(player2Name, this.getColour().switchColour());
        game = new Game(this, player2);
        return game;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", colour=" + colour +
                '}';
    }

    void dropColourDisc(int column) {
        game.getGameBoard()[5][0] = PlayerColours.RED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        return colour == player.colour;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (colour != null ? colour.hashCode() : 0);
        return result;
    }
}
