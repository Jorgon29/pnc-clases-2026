package com.pnc.gamestore.controllers;

import com.pnc.gamestore.common.Genre;
import com.pnc.gamestore.controllers.requestsDtos.FullGameDto;
import com.pnc.gamestore.model.Game;
import com.pnc.gamestore.services.GameService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getAll(){
        return ResponseEntity.ok(gameService.getAll());
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Game>> getByGenre(@Param("genre") Genre genre){
        return ResponseEntity.ok(gameService.findByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<Void> createGame(@RequestBody @Valid FullGameDto game) {
        try{ gameService.createGame(game.game, game.details);
        } catch(BadRequestException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateGame(@RequestBody @Valid FullGameDto game) {

        try{ gameService.update(game.game, game.details);
        } catch(BadRequestException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }
}
