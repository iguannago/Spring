package com.get_in_the_cloud.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 23/11/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EvidenceSharingServiceIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getEvidenceEndpointTest() {
        ResponseEntity<Evidence> response = restTemplate.getForEntity("/EvidenceSharingService/evidences/E002",
                Evidence.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("E002", response.getBody().getId());
        assertEquals("Appeal to the Social Security and Child Support Tribunal", response.getBody().getContent());
    }

    @Test
    public void postEvidenceEndpointTest() throws URISyntaxException {
        ResponseEntity<Evidence> response = restTemplate.postForEntity("/EvidenceSharingService/evidences",
                Evidence.builder("E98", "some content"), Evidence.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("E98", response.getBody().getId());
        assertEquals("some content", response.getBody().getContent());
    }


}