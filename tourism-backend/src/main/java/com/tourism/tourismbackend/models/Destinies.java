package com.tourism.tourismbackend.models;

import com.tourism.tourismbackend.dtos.RegisterDTO;
import com.tourism.tourismbackend.models.enums.DestinyCategory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Table(name = "destinies")
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Destinies {

    public Destinies(String name, DestinyCategory category, String image) {
        this.name = name;
        this.category = category;
        this.image = image;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private DestinyCategory category;

    @Column(nullable = false)
    private String image;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DestinyCategory getCategory() {
        return this.category;
    }

    public void setCategory(DestinyCategory category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
