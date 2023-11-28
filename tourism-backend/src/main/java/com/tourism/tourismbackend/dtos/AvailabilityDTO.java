package com.tourism.tourismbackend.dtos;
import java.util.Date;

public record AvailabilityDTO(Date iniDate, Date endDate, int available) {}