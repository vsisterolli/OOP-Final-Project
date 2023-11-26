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
    public Reservation(Date iniDate, Date endDate, Long userId, Long travelpackageId){
        if(iniDate.after(endDate)) {
            throw new IllegalArgumentException("Invalid dates: iniDate must be before endDate");
        }

        this.iniDate = iniDate;
        this.endDate = endDate;
        this.userId = userId;
        this.travelpackageId = travelpackageId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long travelpackageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTravelpackageId() {
        return travelpackageId;
    }

    public void setTravelpackageId(Long travelpackageId) {
        this.travelpackageId = travelpackageId;
    }
}
