package com.tourism.tourismbackend.controllers;


import com.tourism.tourismbackend.dtos.DeleteDTO;
import com.tourism.tourismbackend.dtos.FullPackageDTO;
import com.tourism.tourismbackend.dtos.PackageDetailsDTO;
import com.tourism.tourismbackend.dtos.TravelPackageDTO;
import com.tourism.tourismbackend.models.TravelPackages;
import com.tourism.tourismbackend.repository.TravelPackagesRepository;
import com.tourism.tourismbackend.services.TravelPackageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class TravelPackagesController{
    @Autowired
    private TravelPackagesRepository repository;
    @Autowired
    private TravelPackageService service;

    @GetMapping
    public List<FullPackageDTO> getTravelPackages() {
        return service.getFullPackages();
    }

    @GetMapping("/{id}")
    public PackageDetailsDTO getTravelPackageById(@PathVariable Long id) {
        return service.getPackageDetails(id);
    }

    @PostMapping
    public ResponseEntity createTravelPackage(@RequestBody @Valid TravelPackageDTO data){
        try{
            service.validateData(data);
            TravelPackages newTravelPackage = new TravelPackages(data.price(), data.destinyId(), data.hotelId(),data.activitiesId(),data.availabilitiesId());
            this.repository.save(newTravelPackage);
            return ResponseEntity.ok().build();
        }catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity register(@RequestBody @Valid DeleteDTO data) {
        this.repository.deleteById(data.id());
        return ResponseEntity.ok().build();
    }
}