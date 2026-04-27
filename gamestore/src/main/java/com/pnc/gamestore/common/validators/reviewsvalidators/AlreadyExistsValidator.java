package com.pnc.gamestore.common.validators.reviewsvalidators;

import com.pnc.gamestore.common.validators.Validator;
import com.pnc.gamestore.repositories.ReviewsRepository;
import com.pnc.gamestore.services.ReviewsService;

public class AlreadyExistsValidator implements Validator {
    private final String user;
    private final Integer id;
    private final ReviewsRepository reviewsRepository;

    public AlreadyExistsValidator(String user, Integer id, ReviewsRepository reviewsRepository) {
        this.user = user;
        this.id = id;
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public boolean validate() {
        return reviewsRepository.findByGameIdAndUser(id, user).isEmpty();
    }
}
