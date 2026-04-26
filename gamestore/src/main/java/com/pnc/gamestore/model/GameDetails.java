package com.pnc.gamestore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.Year;
import java.util.UUID;


@Entity
@Table(name = "game_details")
public class GameDetails {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 2000, nullable = false)
    private String about;

    @Column(nullable = false)
    @Min(value = 1975)
    private Integer publishYear;

    @OneToOne
    @JoinColumn(name = "game_id", unique = true, nullable = true)
    private Game game;

    public GameDetails() {
    }

    public GameDetails(String about, Integer publishYear) {
        this.about = about;
        this.publishYear = publishYear;

        Integer year = Year.now().getValue();
    }
}
