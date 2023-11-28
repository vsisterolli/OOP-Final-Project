package com.tourism.tourismbackend.dtos;

import com.tourism.tourismbackend.models.Activities;
import com.tourism.tourismbackend.models.Availabilities;
import com.tourism.tourismbackend.models.Destinies;
import com.tourism.tourismbackend.models.Hotels;

import java.util.ArrayList;

public record PackageDetailsDTO(
        Long id,
        double price,
        Destinies destiny,
        Hotels hotel,
        ArrayList<Activities> activities,
        ArrayList<Availabilities> availabilities,
        String packetType
) {}
