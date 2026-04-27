package com.pnc.gamestore.services;

import com.pnc.gamestore.common.validators.reviewsvalidators.ReviewsValidator;
import com.pnc.gamestore.model.Review;
import com.pnc.gamestore.repositories.ReviewsRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewsService {
    @Autowired
    ReviewsRepository reviewsRepository;
    @Autowired
    ReviewsValidator reviewsValidator;

    public void create(Review review) throws BadRequestException {
        if (!reviewsValidator.validate(review)){
            throw new BadRequestException();
        }

        reviewsRepository.save(review);
    }

    public void update(Review review){
        reviewsRepository.save(review);
    }

    public Optional<Review> findById(UUID id){
        return reviewsRepository.findById(id);
    }

    public List<Review> findByGameId(Integer gameId){
        return reviewsRepository.findByGameId(gameId);
    }

    public List<Review> findByUser(String user){
        return reviewsRepository.findByUser(user);
    }

    public Optional<Review> findByGameIdAndUser(Integer id, String user){
        return reviewsRepository.findByGameIdAndUser(id, user);
    }
}
