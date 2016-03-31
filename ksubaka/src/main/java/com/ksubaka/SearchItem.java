package com.ksubaka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by davicres on 31/03/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchItem {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("imdbID")
    private String imdbID;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @Override
    public String toString() {
        return "Search{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                '}';
    }
}
