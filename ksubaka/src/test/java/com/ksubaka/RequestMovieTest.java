package com.ksubaka;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by davicres on 31/03/2016.
 */
public class RequestMovieTest {
    @Test
    public void httpRequestRetrieveData() {
        Search search = null;
        RequestMovie requestMovie = new RequestMovie();
        assertNull(search);
        search = requestMovie.call("Indiana Jones");
        System.out.println("eearch: " + search.toString());
        assertNotNull(search);
    }

}
