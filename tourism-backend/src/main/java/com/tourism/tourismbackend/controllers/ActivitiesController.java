package com.tourism.tourismbackend.controllers;

import com.tourism.tourismbackend.dtos.ActivityDTO;
import com.tourism.tourismbackend.models.Activities;
import com.tourism.tourismbackend.repository.ActivitiesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivitiesController {
    @Autowired
    private ActivitiesRepository repository;

    @GetMapping
    public List<Activities> getActivities() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity createActivity(@RequestBody @Valid ActivityDTO data){
        System.out.println("Hey");

        Activities newActivity = new Activities(data.name(), data.day(), data.category());

        this.repository.save(newActivity);

        return ResponseEntity.ok().build();
    }
}
