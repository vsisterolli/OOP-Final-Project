package com.tourism.tourismbackend.controllers;


import com.tourism.tourismbackend.dtos.TravelPackageDTO;
import com.tourism.tourismbackend.models.TravelPackages;
import com.tourism.tourismbackend.repository.TravelPackageRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travels")
public class TravelPackagesController{
    @Autowired
    private TravelPackageRepository repository;

    @GetMapping
    public List<TravelPackages> getTravelPackages() {
        return repository.findAll();
    }
    @PostMapping
    public ResponseEntity createTravelPackage(@RequestBody @Valid TravelPackageDTO data){
        TravelPackages newTravelPackage = new TravelPackages(data.price(), data.destinyId(), data.hotelId(),data.activitiesId(),data.availabilitiesId());

        this.repository.save(newTravelPackage);

        return ResponseEntity.ok().build();
    }

}