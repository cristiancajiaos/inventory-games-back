package com.example.inventorygamesback.repository;

import com.example.inventorygamesback.entity.Platform;
import com.example.inventorygamesback.record.PlatformDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlatformRepository extends JpaRepository<Platform, Long> {

  @Query(value = "SELECT * FROM platforms p", nativeQuery = true)
  List<Platform> getAllPlatforms();

}
