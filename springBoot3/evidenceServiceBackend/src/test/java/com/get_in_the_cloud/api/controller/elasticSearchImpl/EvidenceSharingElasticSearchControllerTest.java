package com.get_in_the_cloud.api.controller.elasticSearchImpl;

import com.get_in_the_cloud.api.domain.elasticSearchAPIResponse.ElasticSearchGETResponse;
import com.get_in_the_cloud.api.domain.evidence.Evidence;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class EvidenceSharingElasticSearchControllerTest {

    @InjectMocks
    private EvidenceSharingElasticSearchController evidenceSharingElasticSearchController;

    @Mock
    private RestTemplate restTemplate;


    @Test@Ignore
    @PrepareForTest({ElasticSearchGETResponse.class, ElasticSearchGETResponse.Hits.class, ControllerLinkBuilder.class,
            ElasticSearchGETResponse.Hits.Source.class})
    public void getEvidenceByIdTest() {
        ElasticSearchGETResponse elasticSearchGETResponseMock = mockElasticSearchGETResponseAndInnerClasses();
        when(restTemplate.getForObject(any(URI.class), eq(ElasticSearchGETResponse.class))).
                thenReturn(elasticSearchGETResponseMock);
        evidenceSharingElasticSearchController.getEvidenceById("someEvidenceId");
    }

    private ElasticSearchGETResponse mockElasticSearchGETResponseAndInnerClasses() {
        ElasticSearchGETResponse elasticSearchGETResponseMock = PowerMockito.mock(ElasticSearchGETResponse.class);
        PowerMockito.mockStatic(ElasticSearchGETResponse.Hits.class);
        PowerMockito.mockStatic(ElasticSearchGETResponse.Hits.Source.class);
        Evidence evidenceMock = mock(Evidence.class);
        ElasticSearchGETResponse.Hits.Source sourceDummy = new ElasticSearchGETResponse.Hits.Source(evidenceMock);
        List<ElasticSearchGETResponse.Hits.Source> sourceDummyList = new ArrayList<>(1);
        sourceDummyList.add(sourceDummy);
        ElasticSearchGETResponse.Hits hitsDummy = new ElasticSearchGETResponse.Hits(sourceDummyList);
        when(elasticSearchGETResponseMock.getHits()).thenReturn(hitsDummy);
        return elasticSearchGETResponseMock;
    }

}
