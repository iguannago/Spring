package com.ksubaka;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by davicres on 31/03/2016.
 */
public class RequestMovieTest {

    private RequestMovie requestMovie = new RequestMovie();
    private Search search = null;

    @Test
    public void httpRequestRetrieveData() {
        RequestMovie requestMovie = new RequestMovie();
        assertNull(search);
        search = requestMovie.call("Indiana Jones");
        System.out.println("search: " + search.toString());
        assertNotNull(search);
    }

    @Test
    public void httpRequestRetrieveTitleYearAndDirectorData() {
        search = requestMovie.call("Indiana Jones");
        String director = search.getSearch().get(0).getDirector();
        assertNotNull(director);
        assertNotEquals("", director);
    }
}
