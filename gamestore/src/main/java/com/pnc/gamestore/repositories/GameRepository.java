package com.pnc.gamestore.repositories;

import com.pnc.gamestore.common.Classification;
import com.pnc.gamestore.common.Genre;
import com.pnc.gamestore.model.Game;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    public List<Game> findByDev(String dev);
    public List<Game> findByDevAndClassification(String dev, Classification classification);
    public List<Game> findByGenre(Genre genre);
    public void deleteById(Integer id);
    public Optional<Game> findByName(String name);
    public Optional<Game> findById(Integer id);
}
