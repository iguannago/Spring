package com.get_in_the_cloud.api.controller.elasticSearchImpl;

import com.get_in_the_cloud.api.domain.evidence.Evidence;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.hateoas.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by davicres on 04/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class EvidenceResourceUtilTest {
    @Test@Ignore
    public void testEvidenceToGETResource() throws Exception {
        Evidence evidence = new Evidence("1", "some content");
        Resource<Evidence> evidenceResource = EvidenceResourceUtil.evidenceToGETResource(evidence);
        System.out.println(evidenceResource);
    }
}
