package com.example.inventorygamesback.service;

import com.example.inventorygamesback.entity.Platform;
import com.example.inventorygamesback.record.PlatformDTO;
import java.util.List;

public interface PlatformService {

  PlatformDTO createPlatform(PlatformDTO platformDTO);

  List<PlatformDTO> getAllPlatforms();

  PlatformDTO getPlatformById(Long id);

  List<PlatformDTO> getAllPlatformsOrderByPlatformName();

  List<PlatformDTO> getAllPlatformsOrderByPlatformAcronym();

  List<PlatformDTO> getAllPlatformsOrderByPlatformNameLike(String name);

}
