package com.get_in_the_cloud.api.controller.elasticSearchImpl;

import com.get_in_the_cloud.api.domain.evidence.Evidence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by davicres on 04/12/2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ControllerLinkBuilder.class})
public class EvidenceResourceUtilTest {

    @Test
    public void testEvidenceToGETResource() throws Exception {
        Evidence evidence = new Evidence("1", "some content");
        PowerMockito.mockStatic(ControllerLinkBuilder.class);

        EvidenceSharingElasticSearchController controllerMock = mock(EvidenceSharingElasticSearchController.class);
        when(ControllerLinkBuilder.methodOn(eq(EvidenceSharingElasticSearchController.class))).
                thenReturn(controllerMock);

        ControllerLinkBuilder controllerLinkBuilderMock = mock(ControllerLinkBuilder.class);
        when(ControllerLinkBuilder.linkTo(controllerMock.getEvidenceById("1"))).thenReturn(controllerLinkBuilderMock);

        when(controllerLinkBuilderMock.slash("1")).thenReturn(controllerLinkBuilderMock);
        when(controllerLinkBuilderMock.withSelfRel()).thenReturn(mock(Link.class));

        Resource<Evidence> evidenceResource = EvidenceResourceUtil.evidenceToGETResource(evidence);
        System.out.println(evidenceResource);
    }

    @Test
    public void testEvidenceToPOSTResource() throws Exception {
        Evidence evidence = new Evidence("1", "some content");
        PowerMockito.mockStatic(ControllerLinkBuilder.class);

        EvidenceSharingElasticSearchController controllerMock = mock(EvidenceSharingElasticSearchController.class);
        when(ControllerLinkBuilder.methodOn(eq(EvidenceSharingElasticSearchController.class))).
                thenReturn(controllerMock);

        ControllerLinkBuilder controllerLinkBuilderMock = mock(ControllerLinkBuilder.class);
        when(ControllerLinkBuilder.linkTo(controllerMock.createEvidence(evidence))).thenReturn(controllerLinkBuilderMock);

        when(controllerLinkBuilderMock.withSelfRel()).thenReturn(mock(Link.class));
        Resource<Evidence> evidenceResource = EvidenceResourceUtil.evidenceToPOSTResource(evidence);
        System.out.println(evidenceResource);
    }
}
