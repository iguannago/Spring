package com.get_in_the_cloud.api.elasticSearchImpl;

/**
 * Created by davicres on 29/11/2016.
 */
public class ElasticSearchResponse {

    private Hits hits;

    public Hits getHits() {
        return hits;
    }

    public void setHits(Hits hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "ElasticSearchResponse{" +
                "hits=" + hits +
                '}';
    }
}
