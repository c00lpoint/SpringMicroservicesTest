package com.c00lpoint.test.ratingdataservice.modules;

import java.util.List;

public class UserRatings {
    private String userId;
    private List<RatingInfo> ratings;

    public UserRatings() {
    }

    public UserRatings(String userId, List<RatingInfo> ratings) {
        this.userId = userId;
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<RatingInfo> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingInfo> ratings) {
        this.ratings = ratings;
    }
}
