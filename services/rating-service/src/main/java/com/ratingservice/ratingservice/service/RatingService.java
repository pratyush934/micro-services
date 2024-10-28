package com.ratingservice.ratingservice.service;

import com.ratingservice.ratingservice.entity.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> getAllRating();

    Rating getRatingById(String ratingId);

    Rating deleteRatingById(String ratingId);

    Rating saveRating(Rating rating);

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
