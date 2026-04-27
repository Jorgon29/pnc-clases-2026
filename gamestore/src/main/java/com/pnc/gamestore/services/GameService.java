package com.pnc.gamestore.services;

import com.pnc.gamestore.common.Genre;
import com.pnc.gamestore.common.validators.Validator;
import com.pnc.gamestore.common.validators.gamevalidators.GameValidator;
import com.pnc.gamestore.common.validators.gamevalidators.GameValidatorImpl;
import com.pnc.gamestore.model.Game;
import com.pnc.gamestore.model.GameDetails;
import com.pnc.gamestore.repositories.GameDetailsRepository;
import com.pnc.gamestore.repositories.GameRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameDetailsRepository gameDetailsRepository;
    @Autowired
    private GameValidator gameValidator;

    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    public List<Game> findByGenre(Genre genre) {
        return gameRepository.findByGenre(genre);
    }

    public void createGame(Game game, GameDetails gameDetails) throws BadRequestException {

        if(!gameValidator.validate(game, gameDetails)) {
            throw new BadRequestException();
        }

        Game saved = gameRepository.save(game);
        if (gameDetails != null) {
            gameDetails.setGame(saved);
            gameDetailsRepository.save(gameDetails);
        }
    }

    public void update(Game game, GameDetails gameDetails) throws BadRequestException {

        if(!gameValidator.validate(game, gameDetails)) {
            throw new BadRequestException();
        }
        gameRepository.save(game);
        if (gameDetails != null && Objects.equals(gameDetails.getGameId(), game.id)) {
            gameDetailsRepository.save(gameDetails);
        }
    }

    public void delete(Integer id)
    {
        gameRepository.deleteById(id);
        if (gameDetailsRepository.findByGameId(id).isPresent()) {
            gameDetailsRepository.deleteByGameId(id);
        }
    }
}
