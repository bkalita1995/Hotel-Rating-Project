package com.microservice.user.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Rating {
    private String ratingId;
    private int rating;
    private String feedback;
    private String userId;
    private String hotelId;
    private Hotel hotel;
}
