package com.pnc.gamestore.common.validators.reviewsvalidators;

import com.pnc.gamestore.common.validators.Validator;
import com.pnc.gamestore.model.Review;
import com.pnc.gamestore.repositories.ReviewsRepository;
import com.pnc.gamestore.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewsValidatorImpl implements ReviewsValidator {
    @Autowired
    private ReviewsRepository reviewsRepository;

    public boolean validate(Review review) {
        Validator alreadyExistsValidator = new AlreadyExistsValidator(review.getUser(), review.getGame().id, reviewsRepository);
        return alreadyExistsValidator.validate();
    }
}
