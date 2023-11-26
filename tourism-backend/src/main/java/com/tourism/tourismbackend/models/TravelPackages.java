package com.tourism.tourismbackend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Table(name = "TravelPackage")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TravelPackages {

    public TravelPackages(double price, Long destinyId, Long hotelId,ArrayList<Long> activitiesId, ArrayList<Long> availabilitiesId){
        this.price = price;
        this.destinyId = destinyId;
        this.hotelId = hotelId;
        this.activitiesId = activitiesId;
        this.availabilitiesId = availabilitiesId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private Long destinyId;

    @Column(nullable = false)
    private Long hotelId;

    @Column(nullable = false)
    private ArrayList<Long> activitiesId = new ArrayList<Long>();

    @Column(nullable = false)
    private ArrayList<Long> availabilitiesId = new ArrayList<Long>();

    //Getters and setters

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getDestinyId() {
        return destinyId;
    }

    public void setDestinyId(Long destinyId) {
        this.destinyId = destinyId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public ArrayList<Long> getActivitiesId() {
        return activitiesId;
    }

    public void setActivitiesId(ArrayList<Long> activitiesId) {
        this.activitiesId = activitiesId;
    }

    public ArrayList<Long> getAvailabilitiesId() {
        return availabilitiesId;
    }

    public void setAvailabilitiesId(ArrayList<Long> availabilitiesId) {
        this.availabilitiesId = availabilitiesId;
    }
}