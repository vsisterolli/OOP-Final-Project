package com.tourism.tourismbackend.dtos;

import com.tourism.tourismbackend.models.enums.DestinyCategory;

import java.util.ArrayList;

public record FullPackageDTO(Long id, double price, Long destinyId, Long hotelId, ArrayList<Long> activitiesId, ArrayList<Long> availabilitiesId, String destinyName, DestinyCategory destinyCategory, String destinyImage) {
}
