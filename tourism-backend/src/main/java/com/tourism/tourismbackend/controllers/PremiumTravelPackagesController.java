package com.tourism.tourismbackend.controllers;


import com.tourism.tourismbackend.dtos.PremiumTravelPackageDTO;
import com.tourism.tourismbackend.models.Availabilities;
import com.tourism.tourismbackend.models.PremiumTravelPackages;
import com.tourism.tourismbackend.repository.PremiumTravelPackagesRepository;
import com.tourism.tourismbackend.services.PremiumPackageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/premiumPackages")
public class PremiumTravelPackagesController{
    @Autowired
    private PremiumTravelPackagesRepository repository;
    @Autowired
    private PremiumPackageService premiumPackagService;

    @GetMapping
    public List<PremiumTravelPackages> getPremiumTravelPackages() {
        return repository.findAll();
    }
    @PostMapping
    public ResponseEntity createPremiumTravelPackage(@RequestBody @Valid PremiumTravelPackageDTO data){

        try {
            premiumPackagService.validateData(data);
            PremiumTravelPackages newTravelPackage = new PremiumTravelPackages(data.price(), data.destinyId(), data.hotelId(),data.activitiesId(),data.availabilitiesId());
            this.repository.save(newTravelPackage);
            return ResponseEntity.ok().build();
        } catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}