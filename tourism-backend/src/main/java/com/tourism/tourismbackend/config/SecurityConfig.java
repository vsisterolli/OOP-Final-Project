package com.tourism.tourismbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
     return httpSecurity
             .csrf(csrf -> csrf.disable())
             .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
             .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
             .authorizeHttpRequests(authorize -> authorize
                     .requestMatchers(HttpMethod.GET,  "/*").permitAll()
                     .requestMatchers(HttpMethod.GET,  "/packages/*").permitAll()
                     .requestMatchers(HttpMethod.POST,  "/reservations").permitAll()
                     .requestMatchers(HttpMethod.POST,  "/auth/*").permitAll()
                     .requestMatchers(HttpMethod.DELETE, "/**").hasAuthority("ADMIN")
                     .requestMatchers(HttpMethod.POST, "/**").hasAuthority("ADMIN")
                     .anyRequest().permitAll()
             )
             .build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
