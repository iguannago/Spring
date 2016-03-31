package com.ksubaka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

/**
 * Created by davicres on 31/03/2016.
 */
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        RequestMovie requestMovie = new RequestMovie();
        ResponseEntity<String> response = requestMovie.call(System.getProperty("movie"));
        log.info("response: " + response);
    }
}
