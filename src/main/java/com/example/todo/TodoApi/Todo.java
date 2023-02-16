package com.example.todo.TodoApi;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String item;
  private Boolean completed;
  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Todo() {}

  public Todo(String item, Boolean completed) {
    this.item = item;
    this.completed = completed;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getItem() {
    return this.item;
  }

  public void setItem(String item) {
    this.item = item;
  }
  
  public Boolean getCompleted() {
    return this.completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
