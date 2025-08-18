package com.example.inventorygamesback.repository;

import com.example.inventorygamesback.entity.Game;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends JpaRepository<Game, Long> {

  @Query(value = "SELECT * FROM games g", nativeQuery = true)
  List<Game> getAllGames();

  @Query(value = "SELECT * FROM games g WHERE g.game_id = :gameId", nativeQuery = true)
  Game getGameById(@Param("gameId") Long gameId);

}
