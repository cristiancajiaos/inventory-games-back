package com.example.inventorygamesback.repository;

import com.example.inventorygamesback.entity.Platform;
import com.example.inventorygamesback.record.PlatformDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlatformRepository extends JpaRepository<Platform, Long> {

  @Query(value = "SELECT * FROM platforms p", nativeQuery = true)
  List<Platform> getAllPlatforms();

  @Query(value = "SELECT * FROM platforms p WHERE p.platform_id = :platformId", nativeQuery = true)
  Platform getPlatformById(@Param("platformId") Long id);

  @Query(value = "SELECT * FROM platforms p ORDER BY p.platform_name", nativeQuery = true)
  List<Platform> getAllPlatformsOrderByPlatformName();

  @Query(value = "SELECT * FROM platforms p ORDER BY p.platform_acronym", nativeQuery = true)
  List<Platform> getAllPlatformsOrderByPlatformAcronym();

  @Query(value = "SELECT * FROM platforms p WHERE LOWER(p.platform_name) LIKE LOWER(CONCAT('%', ?1, '%')) ORDER BY p.platform_name", nativeQuery = true)
  List<Platform> getAllPlatformsOrderByPlatformNameLike(String name);
}
