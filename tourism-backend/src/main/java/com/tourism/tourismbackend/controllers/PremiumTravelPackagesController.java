package com.tourism.tourismbackend.controllers;


import com.tourism.tourismbackend.dtos.DeleteDTO;
import com.tourism.tourismbackend.dtos.FullPackageDTO;
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
    private PremiumPackageService premiumPackageService;

    @GetMapping
    public List<FullPackageDTO> getPremiumTravelPackages() {
        return premiumPackageService.getFullPackages();
    }
    @PostMapping
    public ResponseEntity createPremiumTravelPackage(@RequestBody @Valid PremiumTravelPackageDTO data){

        try {
            premiumPackageService.validateData(data);
            PremiumTravelPackages newTravelPackage = new PremiumTravelPackages(data.price(), data.destinyId(), data.hotelId(),data.activitiesId(),data.availabilitiesId());
            this.repository.save(newTravelPackage);
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