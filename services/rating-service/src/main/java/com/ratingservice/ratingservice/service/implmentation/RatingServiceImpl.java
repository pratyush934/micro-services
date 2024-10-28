package com.ratingservice.ratingservice.service.implmentation;

import com.ratingservice.ratingservice.entity.Rating;
import com.ratingservice.ratingservice.exception.NoRatingFoundException;
import com.ratingservice.ratingservice.repository.RatingRepository;
import com.ratingservice.ratingservice.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(() -> new NoRatingFoundException("Sorry to inform you but I am sorry"+ratingId));
    }

    @Override
    public Rating deleteRatingById(String ratingId) {
        Rating ratingById = getRatingById(ratingId);
        ratingRepository.deleteById(ratingId);
        return ratingById;
    }

    @Override
    public Rating saveRating(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        List<Rating> byUserId = ratingRepository.findByUserId(userId);
        return byUserId;
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        List<Rating> byHotelId = ratingRepository.findByHotelId(hotelId);
        return byHotelId;
    }
}
