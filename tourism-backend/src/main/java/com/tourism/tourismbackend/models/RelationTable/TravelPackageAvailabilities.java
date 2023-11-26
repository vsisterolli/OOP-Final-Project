package com.tourism.tourismbackend.models.RelationTable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Table(name = "TravelPackageAvailability")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TravelPackageAvailabilities {

    public TravelPackageAvailabilities(Long travelPackageId , Long availabilityId) {
        this.travelPackageId = travelPackageId;
        this.availabilityId = availabilityId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long travelPackageId;

    @Column(nullable = false)
    private Long availabilityId;
}