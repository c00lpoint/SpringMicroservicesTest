package com.c00lpoint.test.moviecatalogservice.modules;

import java.util.List;

public class UserRatings {
    private List<RatingInfo> ratings;

    public UserRatings() {
    }

    public List<RatingInfo> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingInfo> ratings) {
        this.ratings = ratings;
    }
}
