package com.selamkd.todosystem.model.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaskID", nullable = false)
    private Integer id;

    @Column(name = "Title")
    private String title;


    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "Description")
    private String description;

    @Column(name = "Status", nullable = false)
    private String status;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "UserTasks",
          joinColumns = @JoinColumn(name = "TaskID"),
          inverseJoinColumns = @JoinColumn(name = "UserID")
  )
  private Set<User> users = new HashSet<>();

  @PrePersist
  protected void onCreate() {
      createdAt = LocalDateTime.now();
      if(this.status == null){
          this.status = "Pending";
      }
  }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
      return description;
    }
    public void setDescription(String description) {
      this.description = description;
    }

    public Set<User> getUsers() {
      return users;
    }

}