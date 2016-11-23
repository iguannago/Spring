package com.get_in_the_cloud.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by davicres on 22/11/2016.
 */
public final class Evidence {
    private final String id;
    private final String content;

    private Evidence(String id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonCreator
    public static Evidence builder(@JsonProperty("id") String id, @JsonProperty("content") String content) {
        return new Evidence(id, content);
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
