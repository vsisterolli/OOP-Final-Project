package com.tourism.tourismbackend.controllers;

import com.tourism.tourismbackend.dtos.AvailabilityDTO;
import com.tourism.tourismbackend.dtos.DeleteDTO;
import com.tourism.tourismbackend.dtos.RegisterDTO;
import com.tourism.tourismbackend.models.Availabilities;
import com.tourism.tourismbackend.models.Users;
import com.tourism.tourismbackend.repository.AvailabilitiesRepository;
import com.tourism.tourismbackend.repository.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/availabilities")
public class AvailabilitiesController {

    @Autowired
    private AvailabilitiesRepository repository;

    @GetMapping
    public List<Availabilities> getUsers() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid AvailabilityDTO data) {

        try {
            Availabilities newAvailability = new Availabilities(data.iniDate(), data.endDate(), data.available());
            this.repository.save(newAvailability);
            return ResponseEntity.ok().build();
        } catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }

    }

    @DeleteMapping
    public ResponseEntity register(@RequestBody @Valid DeleteDTO data) {
        this.repository.deleteById(data.id());
        return ResponseEntity.ok().build();
    }
}