package com.pnc.gamestore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Table(name = "reviews", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"author_user", "game_id"})
})
public class Review {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @NotBlank
    @Column(nullable = false, name = "author_user")
    private String user;

    @NotNull
    @Column(nullable = false)
    private Integer rating;

    @NotBlank
    @Column(length = 1000, nullable = false)
    private String comment;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    public Review() {
    }

    public Review(String user, Integer rating, String comment) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }

    public Game getGame() {
        return game;
    }

    public String getComment() {
        return comment;
    }

    public Integer getRating() {
        return rating;
    }

    public String getUser() {
        return user;
    }

    public UUID getId() {
        return id;
    }
}
