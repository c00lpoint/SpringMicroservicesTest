package com.c00lpoint.test.moviecatalogservice.modules;

public class MovieCatalogInfo {
    private String name;
    private String desc;
    private double rating;

    public MovieCatalogInfo(String name, String desc, double rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
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

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
