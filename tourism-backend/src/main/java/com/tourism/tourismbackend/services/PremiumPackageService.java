package com.tourism.tourismbackend.services;

import com.tourism.tourismbackend.dtos.PremiumTravelPackageDTO;
import com.tourism.tourismbackend.models.Hotels;
import com.tourism.tourismbackend.models.PremiumTravelPackages;
import com.tourism.tourismbackend.repository.HotelsRepository;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PremiumPackageService {

    @Autowired
    private HotelsRepository repository;

    public void validateData(PremiumTravelPackageDTO data) {
        Long hotelId = data.hotelId();

        ArrayList<Long> activitiesId = data.activitiesId();

        Optional<Hotels> hotel = this.repository.findById(hotelId);
        if (hotel.isEmpty() || hotel.get().getStars() < 4) {
            throw new IllegalArgumentException("Invalid hotel ID or hotel does not have at least 4 stars.");
        }

        if (activitiesId.size() < 3) {
            throw new IllegalArgumentException("Premium package does not have at least 3 activities.");
        }
    }
}
