package com.example.nexa.service;

import com.example.nexa.entity.Rating;
import com.example.nexa.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepo ratingRepository;

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }
}

