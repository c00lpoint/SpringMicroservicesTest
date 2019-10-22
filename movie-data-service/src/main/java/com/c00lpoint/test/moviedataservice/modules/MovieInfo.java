package com.c00lpoint.test.moviedataservice.modules;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieInfo {
    @JsonAlias({"id"})
    private long movieId;
    @JsonAlias({"original_title"})
    private String name;
    @JsonAlias({"overview"})
    private String desc;

    public MovieInfo() {
    }

    public MovieInfo(long movieId, String name, String desc) {
        this.movieId = movieId;
        this.name = name;
        this.desc = desc;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
