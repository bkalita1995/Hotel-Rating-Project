package com.microservice.rating.service;

import com.microservice.rating.exception.ResourceNotFoundException;
import com.microservice.rating.model.Rating;
import com.microservice.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    private RestTemplate template;

    public Rating addRating(Rating rating){
        String randomUUID = UUID.randomUUID().toString();
        rating.setRatingId(randomUUID);
        return ratingRepository.save(rating);
    }

    public Rating getRating(String ratingId){
        return ratingRepository.findById(ratingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Not Rating present of given Id "+ratingId));
    }

    public List<Rating> getRatings(){
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingByUserId(String userId){
        return ratingRepository.findByUserId(userId);
    }

    public  List<Rating> getRatingByHotelId(String hotelId){
        return ratingRepository.findByHotelId(hotelId);
    }
}
