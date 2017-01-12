package com.get_in_the_cloud.backend;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 12/01/2017.
 */
public class GameTest {
    @Test
    public void playerStartAGame() throws Exception {
        Player player1 = Player.build("player1");
        Game game = player1.startGame("player2");
        assertNotNull(game);
    }
}
