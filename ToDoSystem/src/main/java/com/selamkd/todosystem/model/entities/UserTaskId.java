package com.selamkd.todosystem.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class UserTaskId implements java.io.Serializable {
    private static final long serialVersionUID = 5641549878408269230L;
    @Column(name = "UserID", nullable = false)
    private Integer userID;

    @Column(name = "TaskID", nullable = false)
    private Integer taskID;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserTaskId entity = (UserTaskId) o;
        return Objects.equals(this.userID, entity.userID) &&
                Objects.equals(this.taskID, entity.taskID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, taskID);
    }

}