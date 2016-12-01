package com.get_in_the_cloud.api.controller.elasticSearchImpl;

import com.get_in_the_cloud.api.domain.evidence.Evidence;
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
public class EvidenceSharingElasticSearchControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getEvidenceEndpointTest() {
        ResponseEntity<Evidence> response = restTemplate.getForEntity("/EvidenceSharingAPI/evidences/E002",
                Evidence.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void postEvidenceEndpointTest() throws URISyntaxException {
        ResponseEntity<String> response = restTemplate.postForEntity("/EvidenceSharingAPI/evidences",
                new Evidence("E98", "some content"), String.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }


}
