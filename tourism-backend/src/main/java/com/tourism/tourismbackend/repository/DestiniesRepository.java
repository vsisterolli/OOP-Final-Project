package com.tourism.tourismbackend.repository;

import com.tourism.tourismbackend.dtos.DestinyDTO;
import com.tourism.tourismbackend.models.Destinies;
import com.tourism.tourismbackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface DestiniesRepository extends JpaRepository<Destinies, Long> {
    DestinyDTO findByName(String Name);
}