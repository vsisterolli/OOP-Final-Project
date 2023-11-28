package com.tourism.tourismbackend.repository;

import com.tourism.tourismbackend.models.PremiumTravelPackages;
import com.tourism.tourismbackend.models.TravelPackages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelPackagesRepository extends JpaRepository<TravelPackages, Long>  {
    List<TravelPackages> findByPackageTypeNot(String packetType);
}
