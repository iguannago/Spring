package com.ksubaka;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 31/03/2016.
 */
public class RequestMusicAlbumTest {

    @Test
    public void httpRequestForMusicAlbumRetrieveData() {
        RequestMusicAlbum requestMusicAlbum = new RequestMusicAlbum();
        ResponseEntity<String> response = requestMusicAlbum.call("Back to Black");
        System.out.println("response: " + response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
