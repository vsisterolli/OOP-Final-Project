package com.tourism.tourismbackend.repository;

import com.tourism.tourismbackend.dtos.HotelDTO;
import com.tourism.tourismbackend.models.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelsRepository extends JpaRepository<Hotels, Long> {
    HotelDTO findByAddress(String address);
}
