package com.tourism.tourismbackend.services;

import com.tourism.tourismbackend.dtos.FullPackageDTO;
import com.tourism.tourismbackend.dtos.PremiumTravelPackageDTO;
import com.tourism.tourismbackend.dtos.TravelPackageDTO;
import com.tourism.tourismbackend.models.*;
import com.tourism.tourismbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TravelPackageService{

    @Autowired
    private TravelPackagesRepository travel_package_repository;

    @Autowired
    private HotelsRepository hotel_repository;

    @Autowired
    private DestiniesRepository destiny_repository;

    @Autowired
    private ActivitiesRepository activities_repository;

    @Autowired
    private AvailabilitiesRepository availabilities_repository;


    public void validateData(PremiumTravelPackageDTO data) {
        double price = data.price();
        Long hotelId = data.hotelId();
        Long destinyId = data.destinyId();
        ArrayList<Long> activitiesId = data.activitiesId();
        ArrayList<Long> availabilitiesId = data.availabilitiesId();

        if(price < 0){
            throw new IllegalArgumentException("Invalid Travel Package price");
        }

        Optional<Hotels> hotel = this.hotel_repository.findById(hotelId);
        if (hotel.isEmpty()) {
            throw new IllegalArgumentException("Invalid hotel ID");
        }

        Optional<Destinies> destiny = this.destiny_repository.findById(destinyId);
        if(destiny.isEmpty()) {
            throw new IllegalArgumentException("Invalid destiny ID");
        }

        for(int i = 0 ; i < activitiesId.size() ; i++){
            Long activityId = activitiesId.get(i);

            Optional<Activities> activity = this.activities_repository.findById(activityId);

            if(activity.isEmpty()){
                throw new IllegalArgumentException(String.format("Invalid Activity ID: %d", activityId));
            }
        }

        for(int i = 0 ; i < availabilitiesId.size() ; i++){
            Long availabilityId = availabilitiesId.get(i);

            Optional<Availabilities> availability = this.availabilities_repository.findById(availabilityId);

            if(availability.isEmpty()){
                throw new IllegalArgumentException(String.format("Invalid Availability ID: %d", availabilityId));
            }
        }

    }

    public List<FullPackageDTO> getFullPackages() {
        List<TravelPackages> packages = travel_package_repository.findAll();
        List<FullPackageDTO> fullPackages = new ArrayList<FullPackageDTO>();
        for(int i = 0; i < packages.size(); i++) {
            TravelPackages currentPackage = packages.get(i);
            Optional<Destinies> destiny = destiny_repository.findById(currentPackage.getDestinyId());
            if(destiny.isEmpty())
                continue;
            FullPackageDTO fullpackage = new FullPackageDTO(
                    currentPackage.getPrice(),
                    currentPackage.getDestinyId(),
                    currentPackage.getHotelId(),
                    currentPackage.getActivitiesId(),
                    currentPackage.getAvailabilitiesId(),
                    destiny.get().getName(),
                    destiny.get().getCategory(),
                    destiny.get().getName()
            );
            fullPackages.add(fullpackage);
        }
        return fullPackages;
    }
}
