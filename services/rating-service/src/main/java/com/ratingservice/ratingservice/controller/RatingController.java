package com.ratingservice.ratingservice.controller;


import com.ratingservice.ratingservice.entity.Rating;
import com.ratingservice.ratingservice.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController {

    private RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> allRating = ratingService.getAllRating();
        return new ResponseEntity<List<Rating>>(allRating, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rating> postRating(@RequestBody Rating rating) {
        Rating rating1 = ratingService.saveRating(rating);
        return new ResponseEntity<Rating>(rating1, HttpStatus.OK);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId) {
        Rating rating = ratingService.getRatingById(ratingId);
        return new ResponseEntity<Rating>(rating, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserID(@PathVariable String userId) {
        List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);
        return new ResponseEntity<List<Rating>>(ratingByUserId, HttpStatus.OK);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
        List<Rating> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<List<Rating>>(ratingByHotelId, HttpStatus.OK);
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Rating> deleteRatingById(@PathVariable String ratingId) {
        Rating rating = ratingService.deleteRatingById(ratingId);
        return new ResponseEntity<Rating>(rating, HttpStatus.OK);
    }
}
