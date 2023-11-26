package com.tourism.tourismbackend.dtos;

import com.tourism.tourismbackend.models.enums.DestinyCategory;

public record DestinyDTO(String name, DestinyCategory category, String image) {}