package com.selamkd.todosystem.model.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
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

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CreatedAt")
    private Instant createdAt;

    @ColumnDefault("'Pending'")
    @Lob
    @Column(name = "Status", nullable = false)
    private String status;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "UserTasks",
          joinColumns = @JoinColumn(name = "TaskID"),
          inverseJoinColumns = @JoinColumn(name = "UserID")
  )
  private Set<User> users;


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

    public LocalDate getCreatedAt() {
        return LocalDate.from(createdAt);
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}