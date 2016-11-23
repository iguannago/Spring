package com.get_in_the_cloud.restServices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by davicres on 23/11/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EvidenceShareServiceIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getEvidenceEndPointTest() {
        ResponseEntity<Evidence> response = restTemplate.getForEntity(
                "/EvidenceShareService/evidences/get/E001", Evidence.class);
        System.out.println(response.getBody());
    }

}
