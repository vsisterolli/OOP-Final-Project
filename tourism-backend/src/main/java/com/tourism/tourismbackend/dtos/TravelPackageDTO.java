package com.tourism.tourismbackend.dtos;

import java.util.ArrayList;

public record TravelPackageDTO(double price, Long destinyId, Long hotelId, ArrayList<Long> activitiesId, ArrayList<Long> availabilitiesId) {
}
