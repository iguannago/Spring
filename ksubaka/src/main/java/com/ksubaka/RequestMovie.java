package com.ksubaka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by davicres on 31/03/2016.
 */
public class RequestMovie {

    private RestTemplate restTemplate = new RestTemplate();

    public Search call(String movie) {
        Search search = restTemplate.getForObject(
                "http://www.omdbapi.com/?s=" + movie + "&type=movie&y=&plot=short&r=json", Search.class);
        for (SearchItem searchitem : search.getSearch()) {
            ResponseEntity<String> response = restTemplate.getForEntity("http://www.omdbapi.com/?i=" +
                    searchitem.getImdbID() + "&y=&plot=short&r=json", String.class);
            getDirectorAndUpdateSearchItem(searchitem, response);

        }
        return search;
    }

    private void getDirectorAndUpdateSearchItem(SearchItem searchitem, ResponseEntity<String> response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode director = root.path("Director");
            searchitem.setDirector(director.asText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
