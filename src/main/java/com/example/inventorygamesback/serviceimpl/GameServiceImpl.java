package com.example.inventorygamesback.serviceimpl;

import com.example.inventorygamesback.entity.Game;
import com.example.inventorygamesback.record.GameDTO;
import com.example.inventorygamesback.repository.GameRepository;
import com.example.inventorygamesback.service.GameService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

  @Autowired
  private GameRepository gameRepository;

  public GameServiceImpl(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  @Override
  public GameDTO createGame(GameDTO gameDTO) {
    Game gameToCreate = convertToEntity(gameDTO);
    Game createdGame = gameRepository.save(gameToCreate);
    return convertToDTO(createdGame);
  }

  @Override
  public List<GameDTO> getAllGames() {
    return gameRepository.getAllGames().stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  private Game convertToEntity(GameDTO gameDTO) {
    return new Game(gameDTO.game_id(), gameDTO.game_title(), gameDTO.platform());
  }

  private GameDTO convertToDTO(Game game) {
    return new GameDTO(game.getGame_id(), game.getTitle(), game.getPlatform());
  }
}
