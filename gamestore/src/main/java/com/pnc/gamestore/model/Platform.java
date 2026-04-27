package com.pnc.gamestore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "platforms")
public class Platform {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String company;


    public Platform() {
    }

    public Platform(String name, String company) {
        this.name = name;
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Platform platform = (Platform) o;
        return Objects.equals(id, platform.id) && Objects.equals(name, platform.name) && Objects.equals(company, platform.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, company);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

}
