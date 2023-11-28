package com.tourism.tourismbackend.models;

import com.tourism.tourismbackend.models.interfaces.PeriodicObject;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Table(name = "availabilities")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Availabilities extends PeriodicObject {
    public Availabilities(Date iniDate, Date endDate, int available)
    {
        if(iniDate.after(endDate)) {
            throw new IllegalArgumentException("Invalid dates: iniDate must be before endDate");
        }
        this.iniDate = iniDate;
        this.endDate = endDate;
        this.available = available;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int available;

    public int getAvailable() {
        return this.available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
