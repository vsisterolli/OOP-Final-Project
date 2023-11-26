package com.tourism.tourismbackend.models.RelationTable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Table(name = "TravelPackageActivities")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TravelPackageActivities {

    public TravelPackageActivities(Long travelPackageId ,Long activityId) {
        this.travelPackageId = travelPackageId;
        this.activityId = activityId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long travelPackageId;

    @Column(nullable = false)
    private Long activityId;
}
