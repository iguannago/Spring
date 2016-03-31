package com.ksubaka;

import org.springframework.web.client.RestTemplate;

/**
 * Created by davicres on 31/03/2016.
 */
public class RequestMovie {

    private RestTemplate restTemplate = new RestTemplate();

    public Search call(String movie) {
        return restTemplate.getForObject(
                "http://www.omdbapi.com/?s="+movie+"&type=movie&y=&plot=short&r=json", Search.class);
    }
}
