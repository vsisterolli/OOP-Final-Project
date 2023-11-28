package com.tourism.tourismbackend.services;

import com.tourism.tourismbackend.dtos.FullPackageDTO;
import com.tourism.tourismbackend.dtos.PremiumTravelPackageDTO;
import com.tourism.tourismbackend.models.*;
import com.tourism.tourismbackend.repository.AvailabilitiesRepository;
import com.tourism.tourismbackend.repository.DestiniesRepository;
import com.tourism.tourismbackend.repository.HotelsRepository;
import com.tourism.tourismbackend.repository.PremiumTravelPackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PremiumPackageService {

    @Autowired
    private HotelsRepository repository;

    @Autowired
    private PremiumTravelPackagesRepository premiumRepository;

    @Autowired
    private DestiniesRepository destiniesRepository;

    @Autowired
    private AvailabilitiesRepository availabilitiesRepository;

    public void validateData(PremiumTravelPackageDTO data) {
        Long hotelId = data.hotelId();

        ArrayList<Long> activitiesId = data.activitiesId();

        Optional<Hotels> hotel = this.repository.findById(hotelId);
        if (hotel.isEmpty() || hotel.get().getStars() < 4) {
            throw new IllegalArgumentException("Invalid hotel ID or hotel does not have at least 4 stars.");
        }

        if (activitiesId.size() < 3) {
            throw new IllegalArgumentException("Premium package does not have at least 3 activities.");
        }
    }

    public List<FullPackageDTO> getFullPackages() {
        List<PremiumTravelPackages> packages = premiumRepository.findByPackageType("PREMIUM");
        List<FullPackageDTO> fullPackages = new ArrayList<FullPackageDTO>();

        for(int i = 0; i < packages.size(); i++) {
            TravelPackages currentPackage = packages.get(i);
            Optional<Destinies> destiny = destiniesRepository.findById(currentPackage.getDestinyId());
            if(destiny.isEmpty())
                continue;

            int allAmount = 0;
            for(int j = 0; j < currentPackage.getAvailabilitiesId().size(); j++) {
                Long currentAvailabilityId = currentPackage.getAvailabilitiesId().get(j);
                Optional<Availabilities> currentAvailability = availabilitiesRepository.findById(currentAvailabilityId);
                if(currentAvailability.isPresent()) {
                    allAmount += currentAvailability.get().getAvailable();
                }
                if(allAmount > 0)
                    break;
            }
            if(allAmount == 0)
                continue;

            FullPackageDTO fullpackage = new FullPackageDTO(
                    currentPackage.getId(),
                    currentPackage.getPrice(),
                    currentPackage.getDestinyId(),
                    currentPackage.getHotelId(),
                    currentPackage.getActivitiesId(),
                    currentPackage.getAvailabilitiesId(),
                    destiny.get().getName(),
                    destiny.get().getCategory(),
                    destiny.get().getImage()
            );
            fullPackages.add(fullpackage);
        }
        return fullPackages;
    }
}
