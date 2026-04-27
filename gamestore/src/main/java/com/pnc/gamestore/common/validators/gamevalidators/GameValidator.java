package com.pnc.gamestore.common.validators.gamevalidators;

import com.pnc.gamestore.common.validators.Validator;
import com.pnc.gamestore.model.Game;
import com.pnc.gamestore.model.GameDetails;

public interface GameValidator {
    public boolean validate(Game game, GameDetails gameDetails);
}
