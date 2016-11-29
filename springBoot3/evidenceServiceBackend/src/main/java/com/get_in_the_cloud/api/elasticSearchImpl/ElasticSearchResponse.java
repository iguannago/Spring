package com.get_in_the_cloud.api.elasticSearchImpl;

import java.util.List;

/**
 * Created by davicres on 29/11/2016.
 */
public class ElasticSearchResponse {
    private Hits hits;

    public static class Hits {
        private List<Source> hits;

        public static class Source {
            private Evidence _source;

            public Evidence get_source() {
                return _source;
            }

            public void set_source(Evidence _source) {
                this._source = _source;
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
