package com.pnc.gamestore.model;

import com.pnc.gamestore.common.Classification;
import com.pnc.gamestore.common.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "video_games")
public class Game {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotBlank
    @Column(nullable = false, unique = true)
    public String name;

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    @NotEmpty
    @ElementCollection
    public Set<Genre> genre;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public Classification classification;

    @NotNull
    @Column(name = "game_developer", nullable = false)
    public String dev;

    @NotNull
    @Column(nullable = false)
    public BigDecimal price;

    @ManyToMany
    @JoinTable(
            name = "game_platforms",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    @NotNull
    @NotEmpty
    public Set<Platform> platforms;

    public Game() {
    }

    public Game(String name, Set<Genre> genre, Classification classification, String dev) {
        this.name = name;
        this.genre = genre;
        this.classification = classification;
        this.dev = dev;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Genre> getGenre() {
        return genre;
    }

    public Classification getClassification() {
        return classification;
    }

    public String getDev() {
        return dev;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Set<Platform> getPlatforms() {
        return platforms;
    }
}