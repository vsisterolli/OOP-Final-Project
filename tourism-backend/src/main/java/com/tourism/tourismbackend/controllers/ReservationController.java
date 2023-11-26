package com.tourism.tourismbackend.controllers;

import com.tourism.tourismbackend.dtos.DeleteDTO;
import com.tourism.tourismbackend.dtos.ReservationDTO;
import com.tourism.tourismbackend.models.Reservation;
import com.tourism.tourismbackend.repository.ReservationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository repository;

    @GetMapping
    public List<Reservation> getReservation() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity createReservation(@RequestBody @Valid ReservationDTO data){
        try{
            Reservation newReservation = new Reservation(data.iniDate(), data.endDate(), data.userId(),data.travelpackageId());
            this.repository.save(newReservation);
            return ResponseEntity.ok().build();
        } catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity register(@RequestBody @Valid DeleteDTO data) {
        this.repository.deleteById(data.id());
        return ResponseEntity.ok().build();
    }
}
