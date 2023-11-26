package com.tourism.tourismbackend.models.interfaces;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public abstract class PeriodicObject {
    @Column(nullable = false)
    protected Date iniDate;
    @Column(nullable = false)
    protected Date endDate;
}
