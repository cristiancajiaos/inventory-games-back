package com.example.inventorygamesback.service;

import com.example.inventorygamesback.entity.Platform;
import com.example.inventorygamesback.record.PlatformDTO;
import java.util.List;

public interface PlatformService {

  PlatformDTO createPlatform(PlatformDTO platformDTO);

  List<PlatformDTO> getAllPlatforms();

  List<PlatformDTO> getAllPlatformsOrderByPlatformName();

  List<PlatformDTO> getAllPlatformsOrderByPlatformAcronym();

}
