package com.tourism.tourismbackend.controllers;

import com.tourism.tourismbackend.dtos.DeleteDTO;
import com.tourism.tourismbackend.dtos.HotelDTO;
import com.tourism.tourismbackend.dtos.RegisterDTO;
import com.tourism.tourismbackend.models.Hotels;
import com.tourism.tourismbackend.models.Users;
import com.tourism.tourismbackend.repository.HotelsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelsController {
    @Autowired
    private HotelsRepository repository;

    @GetMapping
    public List<Hotels> getHotels() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity createHotel(@RequestBody @Valid HotelDTO data){
        if(repository.findByAddress(data.address()) != null)
            return ResponseEntity.badRequest().build();

        Hotels newHotel = new Hotels(data.name(), data.stars(), data.address());

        this.repository.save(newHotel);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity register(@RequestBody @Valid DeleteDTO data) {
        this.repository.deleteById(data.id());
        return ResponseEntity.ok().build();
    }
}
