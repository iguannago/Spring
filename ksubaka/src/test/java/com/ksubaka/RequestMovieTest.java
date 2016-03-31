package com.ksubaka;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 31/03/2016.
 */
public class RequestMovieTest {
    @Test
    public void httpRequestIsOk() {
        RequestMovie requestMovie = new RequestMovie();
        ResponseEntity<String> response = requestMovie.call("Indiana Jones");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }



}
