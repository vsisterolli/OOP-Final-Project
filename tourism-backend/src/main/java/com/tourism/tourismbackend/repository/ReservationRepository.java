package com.tourism.tourismbackend.repository;

import com.tourism.tourismbackend.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}