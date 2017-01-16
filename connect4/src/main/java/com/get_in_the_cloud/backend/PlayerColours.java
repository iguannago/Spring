package com.get_in_the_cloud.backend;

/**
 * Created by davicres on 12/01/2017.
 */
public enum PlayerColours {
    RED, YELLOW;

    PlayerColours switchColour() {
        if (this.name().equals("RED")) {
            return PlayerColours.YELLOW;
        } else {
            return PlayerColours.RED;
        }
    }
}
