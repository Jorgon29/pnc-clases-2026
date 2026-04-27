package com.pnc.gamestore.common.validators.gamevalidators;

import com.pnc.gamestore.common.validators.Validator;
import com.pnc.gamestore.repositories.GameRepository;

public class NameAlreadyInUseValidator implements Validator {
    private final String name;
    private final GameRepository gameRepository;

    public NameAlreadyInUseValidator(GameRepository gameRepository, String name) {
        this.gameRepository = gameRepository;
        this.name = name;
    }

    @Override
    public boolean validate() {
        return gameRepository.findByName(name).isPresent();
    }
}
