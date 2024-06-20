package com.selamkd.todosystem.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UserTasks")
public class UserTask {
    @EmbeddedId
    private UserTaskId id;

    @MapsId("userID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserID", nullable = false)
    private User userID;

    @MapsId("taskID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TaskID", nullable = false)
    private Task taskID;

    public UserTaskId getId() {
        return id;
    }

    public void setId(UserTaskId id) {
        this.id = id;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Task getTaskID() {
        return taskID;
    }

    public void setTaskID(Task taskID) {
        this.taskID = taskID;
    }

}