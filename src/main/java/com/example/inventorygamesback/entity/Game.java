package com.example.inventorygamesback.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "games")
public class Game {

  @Id
  @Column(name = "game_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long game_id;

  @Column(name = "game_title")
  private String title;

  @ManyToOne
  @JoinColumn(name = "platform_id_fk")
  private Platform platform;

  @CreationTimestamp
  private Timestamp created_at;

  @UpdateTimestamp
  private Timestamp updated_at;

  public Game() {
  }

  public Long getGame_id() {
    return game_id;
  }

  public void setGame_id(Long game_id) {
    this.game_id = game_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
