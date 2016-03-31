package com.ksubaka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davicres on 31/03/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Search {

    @JsonProperty("Search")
    private List<SearchItem> search = new ArrayList<SearchItem>();

    public List<SearchItem> getSearch() {
        return search;
    }

    public void setSearch(List<SearchItem> search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "Search{" +
                "search=" + search +
                '}';
    }
}
