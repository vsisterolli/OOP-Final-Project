package com.tourism.tourismbackend.controllers;

import com.tourism.tourismbackend.models.Users;
import com.tourism.tourismbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping
    public List<Users> getUsers() {
        return repository.findAll();
    }

}
