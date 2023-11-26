package com.tourism.tourismbackend.models;

import com.tourism.tourismbackend.repository.HotelsRepository;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@DiscriminatorValue("PREMIUM")
public class PremiumTravelPackages extends TravelPackages {

    public PremiumTravelPackages(double price, Long destinyId, Long hotelId, ArrayList<Long> activitiesId, ArrayList<Long> availabilitiesId){
        super(price, destinyId, hotelId, activitiesId, availabilitiesId);
    }

}