package com.get_in_the_cloud.api.elasticSearchImpl;

/**
 * Created by davicres on 29/11/2016.
 */
public class Source {
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
