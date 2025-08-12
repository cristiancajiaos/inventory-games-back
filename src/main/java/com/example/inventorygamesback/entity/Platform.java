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

  @Column(name = "name", nullable = false, unique = true)
  private String platform_name;

  @CreationTimestamp
  private Timestamp created_at;

  @UpdateTimestamp
  private Timestamp updated_at;

}
