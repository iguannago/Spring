package com.get_in_the_cloud;

import com.get_in_the_cloud.restServices.Evidence;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 22/11/2016.
 */
public class EvidenceTest {
    @Test
    public void evidenceConstructorTest() {
        assertNotNull(new Evidence());
    }
}
