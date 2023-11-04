package com.tourism.tourismbackend.dtos;

import com.tourism.tourismbackend.models.Enums.DestinyCategory;

public record DestinyDTO(String name, DestinyCategory category) {}