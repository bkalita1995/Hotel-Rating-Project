package com.microservice.hotel.service;

import com.microservice.hotel.exception.ResourceNotFoundException;
import com.microservice.hotel.model.Hotel;
import com.microservice.hotel.repository.HotelRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelService {
    @Autowired
    private HotelRespository hotelRespository;

    public Hotel addHotel(Hotel hotel){
        String randomId =UUID.randomUUID().toString();
        hotel.setHotelId(randomId);
        return hotelRespository.save(hotel);
    }
    
    public Hotel getHotelById(String hotelId){
        return hotelRespository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("No Hotel found on given hotel Id "+hotelId));
    }

    public List<Hotel> getHotels(){
        return hotelRespository.findAll();
    }
}
