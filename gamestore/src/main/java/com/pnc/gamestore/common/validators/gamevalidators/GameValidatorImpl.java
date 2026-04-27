package com.pnc.gamestore.common.validators.gamevalidators;

import com.pnc.gamestore.common.validators.Validator;
import com.pnc.gamestore.model.Game;
import com.pnc.gamestore.model.GameDetails;
import com.pnc.gamestore.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameValidatorImpl implements GameValidator {
    @Autowired
    private GameRepository gameRepository;

    @Override
    public boolean validate(Game game, GameDetails gameDetails) {
        Validator nintendoValidator = new NintendoValidator(game.classification, game.platforms);
        YearValidator yearValidator = new YearValidator();
        Validator platformsValidator = new PlatformAmountValidator(game.platforms);
        Validator nameValidator = new NameAlreadyInUseValidator(gameRepository, game.name);

        if (gameDetails != null) {
            yearValidator.setPublishYear(gameDetails.getPublishYear());
        }

        return nintendoValidator.validate() && yearValidator.validate()
                && platformsValidator.validate() && nameValidator.validate()
                ;
    }
}