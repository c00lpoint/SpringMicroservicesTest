package com.c00lpoint.test.moviecatalogservices.modules;

public class RatingInfo {
    private long movieId;
    private double rating;

    public RatingInfo() {
    }

    public RatingInfo(long movieId, double rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
