package com.tourism.tourismbackend.repository;

import com.tourism.tourismbackend.models.PremiumTravelPackages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PremiumTravelPackagesRepository extends JpaRepository<PremiumTravelPackages, Long>  {
    List<PremiumTravelPackages> findByPackageType(String packetType);
}
