package com.get_in_the_cloud;

import com.get_in_the_cloud.restServices.Evidence;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by davicres on 22/11/2016.
 */
public class EvidenceTest {
    @Test
    public void evidenceConstructorTest() {
        assertNotNull(Evidence.builder("E0001", "Appeal to the Social Security and Child Support Tribunal"));
    }

    @Test
    public void evidenceFieldsTest() {
        Evidence evidence = Evidence.builder("E0001", "Appeal to the Social Security and Child Support Tribunal");
        assertTrue(!evidence.getId().isEmpty());
        assertTrue(!evidence.getContent().isEmpty());
    }
}
