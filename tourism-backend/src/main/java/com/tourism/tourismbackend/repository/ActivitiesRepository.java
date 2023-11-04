package com.tourism.tourismbackend.repository;

import com.tourism.tourismbackend.models.Activities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivitiesRepository extends JpaRepository<Activities, Long> {
}
