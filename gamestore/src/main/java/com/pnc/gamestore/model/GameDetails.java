package com.pnc.gamestore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.Year;
import java.util.UUID;

@Entity
@Table(name = "game_details")
public class GameDetails {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(length = 2000, nullable = false)
    private String about;

    public UUID getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }

    public Game getGame() {
        return game;
    }

    @NotNull
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
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getGameId(){
        return game.id;
    }

    public int  getPublishYear() {
        return publishYear;
    }
}
