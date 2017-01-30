package com.get_in_the_cloud.backend;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 12/01/2017.
 */
public class PlayerTest {

    @Test
    public void playerInstantiation() throws Exception {
        Player player = Player.builder().name("player1").colour(PlayerColours.RED).build();
        assertEquals("player1", player.getName());
        assertEquals(PlayerColours.RED, player.getColour());
    }

}
