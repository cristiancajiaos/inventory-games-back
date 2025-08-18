package com.example.inventorygamesback.service;

import com.example.inventorygamesback.record.GameDTO;
import java.util.List;

public interface GameService {

  GameDTO createGame(GameDTO gameDTO);

  List<GameDTO> getAllGames();

  GameDTO getGameById(Long gameId);
}
