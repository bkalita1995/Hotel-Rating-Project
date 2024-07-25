package com.microservice.rating.controller;

import com.microservice.rating.model.Rating;
import com.microservice.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return new ResponseEntity<>(ratingService.addRating(rating), HttpStatus.CREATED);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable String ratingId){
        return new ResponseEntity<>(ratingService.getRating(ratingId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return  new ResponseEntity<>(ratingService.getRatings(),HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return new ResponseEntity<>(ratingService.getRatingByUserId(userId),HttpStatus.OK);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return  new ResponseEntity<>(ratingService.getRatingByHotelId(hotelId),HttpStatus.OK);
    }
}
