package com.tourism.tourismbackend.controllers;

import com.tourism.tourismbackend.dtos.AuthenticationDTO;
import com.tourism.tourismbackend.dtos.LoginResponseDTO;
import com.tourism.tourismbackend.dtos.RegisterDTO;
import com.tourism.tourismbackend.models.Users;
import com.tourism.tourismbackend.models.enums.UserRoles;
import com.tourism.tourismbackend.repository.UsersRepository;
import com.tourism.tourismbackend.services.TokenServices;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/auth", produces="application/json", method = {RequestMethod.POST})
public class AuthenticationController {

    @Autowired
    private TokenServices tokenServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersRepository repository;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenServices.generateToken((Users) auth.getPrincipal());
        var user = repository.findByEmail(data.email());

        return ResponseEntity.ok(new LoginResponseDTO(token, user.getPassword(), data.email()));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        System.out.println("Hey");
        if(this.repository.findByEmail(data.email()) != null)
            return ResponseEntity.badRequest().build();

        String newPassword = new BCryptPasswordEncoder().encode(data.password());

        Users newUser = new Users(data.name(), data.email(), newPassword, UserRoles.USER);

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
