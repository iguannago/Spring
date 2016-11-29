package com.get_in_the_cloud.api.elasticSearchImpl.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by davicres on 29/11/2016.
 */
public final class ElasticSearchResponse {
    private final Hits hits;

    @JsonCreator
    public ElasticSearchResponse(@JsonProperty("hits" )Hits hits) {
        this.hits = hits;
    }

    public static final class Hits {
        private final List<Source> hits;

        @JsonCreator
        public Hits(@JsonProperty("hits") List<Source> hits) {
            this.hits = hits;
        }

        public static final class Source {
            private final Evidence _source;

            @JsonCreator
            public Source(@JsonProperty("_source") Evidence source) {
                _source = source;
            }

            public Evidence get_source() {
                return _source;
            }


            @Override
            public String toString() {
                return "Source{" +
                        "_source=" + _source +
                        '}';
            }
        }


        public List<Source> getHits() {
            return hits;
        }


        @Override
        public String toString() {
            return "Hits{" +
                    "hits=" + hits +
                    '}';
        }
    }

    public Hits getHits() {
        return hits;
    }


    @Override
    public String toString() {
        return "ElasticSearchResponse{" +
                "hits=" + hits +
                '}';
    }
}
