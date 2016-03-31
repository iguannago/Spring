package com.ksubaka;

import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Created by davicres on 31/03/2016.
 */
public class RequestMusicAlbum{
    private RestOperations restTemplate = new RestTemplate();

    public MusicAlbum call(String musicAlbum) {
        return restTemplate.getForObject(
                "https://api.spotify.com/v1/search?q=" +musicAlbum+"&type=album&market=US", MusicAlbum.class);
    }
}
