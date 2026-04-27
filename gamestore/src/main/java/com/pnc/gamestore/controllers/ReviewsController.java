package com.pnc.gamestore.controllers;

import com.pnc.gamestore.model.Review;
import com.pnc.gamestore.services.ReviewsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("reviews")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @GetMapping("/{id}")
    public Optional<Review> findById(UUID id){
        return reviewsService.findById(id);
    }

    @GetMapping("/user/{user}")
    public List<Review> findByUser(@PathVariable String user){
        return reviewsService.findByUser(user);
    }

    @GetMapping("/game/{game}")
    public List<Review> findByGame(@PathVariable Integer game){
        return reviewsService.findByGameId(game);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid Review review){
        try {
            reviewsService.create(review);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping
    public void update(@RequestBody @Valid Review review){
        reviewsService.update(review);
    }
}
