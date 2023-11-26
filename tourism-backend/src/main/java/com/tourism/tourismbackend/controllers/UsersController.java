package com.tourism.tourismbackend.controllers;

import com.tourism.tourismbackend.dtos.UserDTO;
import com.tourism.tourismbackend.dtos.UserResponseDTO;
import com.tourism.tourismbackend.models.Users;
import com.tourism.tourismbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping
    public List<UserResponseDTO> getUsers() {
        List<Users> users = repository.findAll();
        List<UserResponseDTO> userDtos = users.stream()
                .map(user -> new UserResponseDTO(user.getName(), user.getEmail()))
                .toList();
        return userDtos;
    }

}
