package com.example.inventorygamesback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "platforms")
public class Platform {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long platform_id;

  @Column(name = "platform_name", nullable = false, unique = true)
  private String platform_name;

  @Column(name = "platform_acronym")
  private String platform_acronym;

  @CreationTimestamp
  private Timestamp created_at;

  @UpdateTimestamp
  private Timestamp updated_at;

  public Platform() {
  }

  public Platform(Long platform_id, String platform_name, String platform_acronym) {
    this.platform_id = platform_id;
    this.platform_name = platform_name;
    this.platform_acronym = platform_acronym;
  }

  public Long getPlatform_id() {
    return platform_id;
  }

  public void setPlatform_id(Long platform_id) {
    this.platform_id = platform_id;
  }

  public String getPlatform_name() {
    return platform_name;
  }

  public void setPlatform_name(String platform_name) {
    this.platform_name = platform_name;
  }

  public String getPlatform_acronym() {
    return platform_acronym;
  }

  public void setPlatform_acronym(String platform_acronym) {
    this.platform_acronym = platform_acronym;
  }
}
