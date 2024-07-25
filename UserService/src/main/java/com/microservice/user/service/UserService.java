package com.microservice.user.service;

import com.microservice.user.exception.ResourceNotFoundException;
import com.microservice.user.external.services.HotelService;
import com.microservice.user.model.Hotel;
import com.microservice.user.model.Rating;
import com.microservice.user.model.User;
import com.microservice.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private String HOTEL_SERVICE_HOST = "http://HOTEL-SERVICE/hotels/";
    private String RATING_SERVICE_HOST = "http://RATING-SERVICE/ratings/users/";
    private Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    public User createUser(User user) {
        String randomUUID = UUID.randomUUID().toString();
        user.setUserId(randomUUID);
        return userRepository.save(user);
    }

    public User getUserById(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by given user Id"));
        Rating[] restObject = restTemplate
                .getForObject(String.format("%s%s",RATING_SERVICE_HOST,user.getUserId()), Rating[].class);

        List<Rating> listOfRating = (Arrays.stream(restObject).toList()).stream().map(
                rating -> {
                    // ResponseEntity<Hotel> hotelEntity =restTemplate
                       //     .getForEntity(String.format("%s%s",HOTEL_SERVICE_HOST,rating.getHotelId()), Hotel.class);
                    Hotel hotel = hotelService.getHotel(rating.getHotelId());
                    rating.setHotel(hotel);
                    return rating;
                }
        ).collect(Collectors.toList());


        user.setListOFRating(listOfRating);
        return user;

    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
