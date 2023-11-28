package com.tourism.tourismbackend.models;


import com.tourism.tourismbackend.models.interfaces.PeriodicObject;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Table(name = "Reservation")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reservation extends PeriodicObject {
    public Reservation(Date iniDate, Date endDate, Long userId, Long travelPackageId){
        if(iniDate.after(endDate)) {
            throw new IllegalArgumentException("Invalid dates: iniDate must be before endDate");
        }

        this.iniDate = iniDate;
        this.endDate = endDate;
        this.userId = userId;
        this.travelPackageId = travelPackageId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long travelPackageId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long gettravelPackageId() {
        return travelPackageId;
    }

    public void settravelPackageId(Long travelPackageId) {
        this.travelPackageId = travelPackageId;
    }
}
