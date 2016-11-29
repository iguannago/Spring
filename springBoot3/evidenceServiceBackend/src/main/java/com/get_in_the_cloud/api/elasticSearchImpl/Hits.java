package com.get_in_the_cloud.api.elasticSearchImpl;

import java.util.List;

/**
 * Created by davicres on 29/11/2016.
 */
public class Hits {
    private List<Source> hits;

    public List<Source> getHits() {
        return hits;
    }

    public void setHits(List<Source> hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "Hits{" +
                "hits=" + hits +
                '}';
    }
}
