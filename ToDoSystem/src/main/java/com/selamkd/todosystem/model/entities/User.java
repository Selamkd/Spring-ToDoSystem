package com.selamkd.todosystem.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID", nullable = false)
    private Integer id;

    @Column(name = "UserName", length = 100)
    private String userName;

    @Column(name = "UserPassword", length = 100)
    private String userPassword;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "UserTasks",
            joinColumns = @JoinColumn(name = "UserID"),
            inverseJoinColumns = @JoinColumn(name = "TaskID")

    )
     private List<Task> tasks;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}