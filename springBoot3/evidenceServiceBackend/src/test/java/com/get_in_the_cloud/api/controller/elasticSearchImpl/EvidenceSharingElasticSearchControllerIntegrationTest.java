package com.get_in_the_cloud.api.controller.elasticSearchImpl;

import com.get_in_the_cloud.api.domain.evidence.Evidence;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 23/11/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EvidenceSharingElasticSearchControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final Node node = new NodeBuilder().node().start();
    private final Client client = node.client();

    @Test@Ignore
    public void getEvidenceEndpointTest() {
        CreateIndexRequest indexRequest = new CreateIndexRequest("evidences");
        client.admin().indices().create(indexRequest).actionGet();

        client.admin().indices().prepareTypesExists("evidences").setTypes("evidences").execute();

//        PutMappingResponse response = client.admin().indices().preparePutMapping(schemaName).setSource(mapping)
//                .setType("evidence").execute().actionGet();


        ResponseEntity<String> response = restTemplate.getForEntity("/EvidenceSharingAPI/evidences/E001", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println(response);
    }

    @Test
    public void postEvidenceEndpointTest() {
        ResponseEntity<String> response = restTemplate.postForEntity("/EvidenceSharingAPI/evidences",
                new Evidence("E001", "some content"), String.class);
        System.out.println(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @After
    public void tearDown() throws Exception {
        DeleteIndexRequest indexRequest = new DeleteIndexRequest("evidences");
        client.admin().indices().delete(indexRequest).actionGet();
        node.close();
    }
}
