package com.tourism.tourismbackend.repository;

import com.tourism.tourismbackend.dtos.AvailabilityDTO;
import com.tourism.tourismbackend.models.Availabilities;
import com.tourism.tourismbackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AvailabilitiesRepository extends JpaRepository<Availabilities, Long> {
}