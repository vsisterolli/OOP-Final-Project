package com.tourism.tourismbackend.dtos;

import com.tourism.tourismbackend.models.enums.ActivityCategory;

public record ActivityDTO (String name, int day, ActivityCategory category){
}
