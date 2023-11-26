package com.tourism.tourismbackend.dtos;

import java.util.Date;

public record ReservationDTO(Date iniDate,Date endDate,Long userId,Long travelpackageId){
}
