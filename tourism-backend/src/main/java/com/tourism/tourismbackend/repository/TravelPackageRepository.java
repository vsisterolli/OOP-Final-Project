package com.tourism.tourismbackend.repository;

import com.tourism.tourismbackend.models.TravelPackages;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TravelPackageRepository extends JpaRepository<TravelPackages, Long>  {
}
