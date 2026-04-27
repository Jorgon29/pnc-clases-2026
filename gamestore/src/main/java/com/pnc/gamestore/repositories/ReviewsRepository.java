package com.pnc.gamestore.repositories;

import com.pnc.gamestore.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, UUID> {
    public List<Review> findByGameId(Integer gameId);
    public List<Review> findByUser(String user);
    public Optional<Review> findByGameIdAndUser(Integer id, String user);
}
