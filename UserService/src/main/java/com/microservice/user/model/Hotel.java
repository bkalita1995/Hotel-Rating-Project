package com.microservice.user.model;

import lombok.Data;

@Data
public class Hotel {
    private String hotelId;
    private String hotelName;
    private String hotelLocation;
    private String description;
}
