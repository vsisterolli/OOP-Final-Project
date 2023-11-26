package com.tourism.tourismbackend.models;

import com.tourism.tourismbackend.models.enums.ActivityCategory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table(name = "activities")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Activities {
    public Activities (String name, int day, ActivityCategory category){
        this.name = name;
        this.day = day;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int day;

    @Column(nullable = false)
    private ActivityCategory category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public ActivityCategory getCategory() {
        return category;
    }

    public void setCategory(ActivityCategory category) {
        this.category = category;
    }
}
