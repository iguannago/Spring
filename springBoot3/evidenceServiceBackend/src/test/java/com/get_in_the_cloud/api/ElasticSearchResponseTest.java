package com.get_in_the_cloud.api;

import com.get_in_the_cloud.api.elasticSearchImpl.pojo.ElasticSearchResponse;
import com.get_in_the_cloud.api.elasticSearchImpl.pojo.Evidence;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 29/11/2016.
 */
public class ElasticSearchResponseTest {
    @Test
    public void elasticSearchResponseFieldsTest() {
        List<ElasticSearchResponse.Hits.Source> hitList = new ArrayList<>(1);
        hitList.add(new ElasticSearchResponse.Hits.Source(new Evidence("id1", "some content")));
        ElasticSearchResponse.Hits hits = new ElasticSearchResponse.Hits(hitList);
        ElasticSearchResponse elasticSearchResponse = new ElasticSearchResponse(hits);
        assertNotNull(elasticSearchResponse);
    }
}
