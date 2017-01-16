package com.get_in_the_cloud.backend;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 16/01/2017.
 */
public class PlayerColoursTest {
    @Test
    public void switchColour() throws Exception {
        PlayerColours colour = PlayerColours.RED;
        assertEquals("RED", colour.name());
        System.out.println("colour is: " + colour);
        colour = colour.switchColour();
        assertEquals("YELLOW", colour.name());
        System.out.println("switch and colour is: " + colour);
        colour = colour.switchColour();
        assertEquals("RED", colour.name());
        System.out.println("switch and colour is: " + colour);
    }
}
