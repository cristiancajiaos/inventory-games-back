package com.example.inventorygamesback.controller;

import com.example.inventorygamesback.record.PlatformDTO;
import com.example.inventorygamesback.service.PlatformService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/platforms")
public class PlatformController {

  private final PlatformService platformService;

  public PlatformController(PlatformService platformService) {
    this.platformService = platformService;
  }

  @PostMapping
  public ResponseEntity<PlatformDTO> createPlatform(@RequestBody PlatformDTO platformDTO) {
    PlatformDTO createdPlatform = platformService.createPlatform(platformDTO);
    return ResponseEntity.ok(createdPlatform);
  }

  @GetMapping
  public List<PlatformDTO> getAllPlatforms() {
    return platformService.getAllPlatforms();
  }

  @GetMapping("/order-name")
  public List<PlatformDTO> getAllPlatformsOrderByPlatformName() {
    return platformService.getAllPlatformsOrderByPlatformName();
  }


}
