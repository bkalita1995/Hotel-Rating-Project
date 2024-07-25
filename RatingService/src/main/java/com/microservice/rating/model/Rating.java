package com.microservice.rating.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Rating {
    @Id
    private String ratingId;
    private int rating;
    private String feedback;
    private String userId;
    private String hotelId;
}
