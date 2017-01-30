package com.get_in_the_cloud.backend;

import lombok.Builder;
import lombok.Value;

/**
 * Created by davicres on 12/01/2017.
 */
@Value
@Builder
final class Player {
    private final String name;
    private final PlayerColours colour;

    Game startGame(String player2Name) {
        Player player2 = Player.builder().name(player2Name).colour(this.getColour().switchColour()).build();
        return new Game(this, player2);
    }

}
