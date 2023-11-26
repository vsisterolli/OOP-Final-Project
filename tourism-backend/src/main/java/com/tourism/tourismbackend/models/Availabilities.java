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
    public Availabilities(Date iniDate, Date endDate, int qntd_disponivel)
    {
        this.iniDate = iniDate;
        this.endDate = endDate;
        this.qntd_disponivel = qntd_disponivel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int qntd_disponivel;

    public int getQntd_disponivel() {
        return this.qntd_disponivel;
    }

    public void setQntd_disponivel(int qntd_disponivel) {
        this.qntd_disponivel = qntd_disponivel;
    }

    public Date getIniDate() {
        return this.iniDate;
    }

    public void setIniDate(Date iniDate) {
        this.iniDate = iniDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
