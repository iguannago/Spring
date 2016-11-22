package com.get_in_the_cloud.restServices;

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

    public static Evidence builder(String id, String content) {
        return new Evidence(id, content);
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
