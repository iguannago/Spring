package com.get_in_the_cloud.restServices;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by davicres on 22/11/2016.
 */
public class EvidenceTest {
    @Test
    public void evidenceConstructorTest() {
        assertNotNull(Evidence.builder("some ID", "some content"));
    }

    @Test
    public void evidenceFieldsTest() {
        Evidence evidence = Evidence.builder("some ID", "some content");
        assertTrue(!evidence.getId().isEmpty());
        assertTrue(!evidence.getContent().isEmpty());
    }
}
