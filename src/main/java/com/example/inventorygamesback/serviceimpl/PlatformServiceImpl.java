package com.example.inventorygamesback.serviceimpl;

import com.example.inventorygamesback.entity.Platform;
import com.example.inventorygamesback.record.PlatformDTO;
import com.example.inventorygamesback.repository.PlatformRepository;
import com.example.inventorygamesback.service.PlatformService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformServiceImpl implements PlatformService {

  @Autowired
  private PlatformRepository platformRepository;

  public PlatformServiceImpl(
      PlatformRepository platformRepository) {
    this.platformRepository = platformRepository;
  }

  @Override
  public PlatformDTO createPlatform(PlatformDTO platformDTO) {
    Platform platformToCreate = convertToEntity(platformDTO);
    Platform createdPlatform = platformRepository.save(platformToCreate);
    return convertToDTO(createdPlatform);
  }

  @Override
  public List<PlatformDTO> getAllPlatforms() {
    return platformRepository.getAllPlatforms().stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public List<PlatformDTO> getAllPlatformsOrderByPlatformName() {
    return platformRepository.getAllPlatformsOrderByPlatformName().stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<PlatformDTO> getAllPlatformsOrderByPlatformAcronym() {
    return platformRepository.getAllPlatformsOrderByPlatformAcronym().stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }

  @Override
  public List<PlatformDTO> getAllPlatformsOrderByPlatformNameLike(String name) {
    return platformRepository.getAllPlatformsOrderByPlatformNameLike(name).stream().map(this::convertToDTO).collect(
        Collectors.toList());
  }


  private PlatformDTO convertToDTO(Platform platform) {
    return new PlatformDTO(platform.getPlatform_id(), platform.getPlatform_name(),
        platform.getPlatform_acronym());
  }

  private Platform convertToEntity(PlatformDTO platformDTO) {
    return new Platform(platformDTO.platform_id(), platformDTO.platform_name(), platformDTO.platform_acronym());
  }
}
