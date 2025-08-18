package com.example.inventorygamesback.controller;

import com.example.inventorygamesback.entity.Game;
import com.example.inventorygamesback.record.GameDTO;
import com.example.inventorygamesback.service.GameService;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.type.internal.UserTypeJavaTypeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/games")
public class GameController {

  @Autowired
  private GameService gameService;

  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @PostMapping
  public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO gameDTO) {
    GameDTO createdGame = gameService.createGame(gameDTO);
    return ResponseEntity.ok(createdGame);
  }

  @GetMapping
  public ResponseEntity<List<GameDTO>> getAllGames() {
    List<GameDTO> games = gameService.getAllGames();
    return ResponseEntity.ok(games);
  }

  @GetMapping("/{gameId}")
  public ResponseEntity<GameDTO> getGameById(@PathVariable("gameId") Long gameId) {
    try {
      GameDTO foundGame = gameService.getGameById(gameId);
      return ResponseEntity.ok(foundGame);
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/platform/{platformId}")
  public ResponseEntity<List<GameDTO>> getGamesByPlatform(@PathVariable("platformId") Long platformId) {
    List<GameDTO> foundGames = gameService.getGamesByPlatform(platformId);
    return ResponseEntity.ok(foundGames);
  }

  @PutMapping("/{gameId}")
  public ResponseEntity<GameDTO> updateGame(@PathVariable("gameId") Long gameId, @RequestBody GameDTO gameDTO) {
    try {
      GameDTO updatedGame = gameService.updateGame(gameId, gameDTO);
      return ResponseEntity.ok(updatedGame);
    } catch (Exception ex) {
      System.err.println("Error: " + ex);
      return ResponseEntity.notFound().build();
    }
  }
}
