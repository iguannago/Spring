package com.get_in_the_cloud.restServices;

/**
 * Created by davicres on 22/11/2016.
 */
public final class Evidence {
    private final String id;

    private Evidence(String id, String content) {
        this.id = id;
    }

    public static Evidence builder(String id, String content) {
        return new Evidence(id, content);
    }

    public String getId() {
        return id;
    }

}
