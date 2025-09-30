package org.example.data;

public interface Rateable <T> {
    public static final Rating rating = Rating.NOT_RATED;

    T applyRating(Rating rating);
}
