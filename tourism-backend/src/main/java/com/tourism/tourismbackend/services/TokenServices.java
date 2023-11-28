package com.tourism.tourismbackend.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.tourism.tourismbackend.models.Users;
import com.tourism.tourismbackend.models.enums.UserRoles;
import com.tourism.tourismbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenServices {

    @Value("${api.security.token.secret}")
    String secret;

    @Autowired
    private UsersRepository usersRepository;

    public String generateToken(Users user) {
        try {
            // I won't use store it on application properties since this is a college project
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("tourism")
                    .withSubject(user.getEmail())
                    .sign(algorithm);
        } catch(JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String getUserEmailByToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("tourism")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch(JWTVerificationException exception) {
            return "";
        }
    }

    public Long getUserIdByToken(String token) {
        String email = getUserEmailByToken(token);
        if(email == null)
            return null;
        return usersRepository.findByEmail(email).getId();
    }
}
