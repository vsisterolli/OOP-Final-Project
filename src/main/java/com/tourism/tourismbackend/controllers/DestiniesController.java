package com.tourism.tourismbackend.controllers;

import com.tourism.tourismbackend.dtos.DestinyDTO;
import com.tourism.tourismbackend.dtos.RegisterDTO;
import com.tourism.tourismbackend.models.Destinies;
import com.tourism.tourismbackend.models.Users;
import com.tourism.tourismbackend.repository.DestiniesRepository;
import com.tourism.tourismbackend.repository.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinies")
public class DestiniesController {

    @Autowired
    private DestiniesRepository repository;

    @GetMapping
    public List<Destinies> getUsers() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid DestinyDTO data) {
        System.out.println("Hey");
        if(this.repository.findByName(data.name()) != null)
            return ResponseEntity.badRequest().build();

        Destinies newDestiny = new Destinies(data.name(), data.category());

        this.repository.save(newDestiny);

        return ResponseEntity.ok().build();
    }
}
