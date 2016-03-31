package com.ksubaka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by davicres on 31/03/2016.
 */
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        String api = System.getProperty("api");
        String movie = System.getProperty("movie");

        RestTemplate restTemplate = new RestTemplate();
        if (api.equals("imdb")) {
            Search search = restTemplate.getForObject(
                    "http://www.omdbapi.com/?s=Indiana Jones&type=movie&y=&plot=short&r=json", Search.class);
            log.info(search.getSearch().toString());
        }
    }
}
