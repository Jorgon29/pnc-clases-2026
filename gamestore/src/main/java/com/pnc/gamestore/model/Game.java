package com.pnc.gamestore.model;

import com.pnc.gamestore.common.Classification;
import com.pnc.gamestore.common.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "video_games")
public class Game {
    @Id
    @Column
    public Integer id;

    @Column(nullable = false, unique = true)
    public String name;

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    @NotEmpty
    @ElementCollection
    public Set<Genre> genre;

    @Column(nullable = false)
    public Classification classification;

    @Column(name = "game_developer", nullable = false)
    public String dev;

    @OneToOne(mappedBy = "game")
    public GameDetails details;

    @OneToMany(mappedBy = "game")
    public List<Reviews> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "game_platforms",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    public List<Platforms> platforms = new ArrayList<>();

    public Game() {
    }

    public Game(Integer id, String name, Genre genre, Classification classification, String dev) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.classification = classification;
        this.dev = dev;
    }
}