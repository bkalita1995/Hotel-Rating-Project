package com.microservice.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Hotel {
    @Id
    private String hotelId;
    private String hotelName;
    private String hotelLocation;
    private String description;
}
