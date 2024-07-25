package com.microservice.hotel.repository;

import com.microservice.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRespository  extends JpaRepository<Hotel,String> {
}
