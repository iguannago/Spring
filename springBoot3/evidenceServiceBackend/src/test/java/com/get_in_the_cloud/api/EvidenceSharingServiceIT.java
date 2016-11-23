package com.get_in_the_cloud.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void getEvidenceEndPointTest() {
        ResponseEntity<Evidence> response = restTemplate.getForEntity(
                "/EvidenceSharingService/evidences/get/E002", Evidence.class);
        assertEquals("E002", response.getBody().getId());
        assertEquals("Appeal to the Social Security and Child Support Tribunal", response.getBody().getContent());
    }

}
