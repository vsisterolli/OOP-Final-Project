package com.tourism.tourismbackend.controllers;

import com.tourism.tourismbackend.config.SecurityFilter;
import com.tourism.tourismbackend.dtos.DeleteDTO;
import com.tourism.tourismbackend.dtos.ReservationDTO;
import com.tourism.tourismbackend.models.Reservation;
import com.tourism.tourismbackend.repository.ReservationRepository;
import com.tourism.tourismbackend.services.TokenServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository repository;

    @Autowired
    private TokenServices tokenServices;

    @Autowired
    private SecurityFilter security;

    @GetMapping
    public List<Reservation> getReservation() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity createReservation(@RequestBody @Valid ReservationDTO data, HttpServletRequest request){
        try{
            String token = security.recoverToken(request);
            if(token == null)
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            Long userId = tokenServices.getUserIdByToken(token);
            if(userId == null)
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

            Reservation newReservation = new Reservation(data.iniDate(), data.endDate(), userId, data.travelPackageId());
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
