package com.get_in_the_cloud.api;

import com.get_in_the_cloud.api.elasticSearchImpl.pojo.Evidence;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by davicres on 22/11/2016.
 */
public class EvidenceTest {
    @Test
    public void evidenceConstructorTest() {
        assertNotNull(new Evidence("some ID", "some content"));
    }

    @Test
    public void evidenceFieldsTest() {
        Evidence evidence = new Evidence("some ID", "some content");
        assertTrue(!evidence.getEvidenceID().isEmpty());
        assertTrue(!evidence.getContent().isEmpty());
    }
}
