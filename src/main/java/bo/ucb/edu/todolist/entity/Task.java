package bo.ucb.edu.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @NotBlank
    @Size(max = 255)
    @Column(name = "task_name")
    private String taskName;

    @NotNull
    @Column(name = "due_date")
    private java.sql.Timestamp dueDate;

    @NotNull
    @Column(name = "status")
    private Boolean status = false;

    @Column(name = "completion_time")
    private java.sql.Timestamp completionTime;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    // Getters and setters

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Timestamp completionTime) {
        this.completionTime = completionTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task() {
    }

    public Task(Long taskId, String taskName, Timestamp dueDate, Boolean status, Timestamp completionTime, User user) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.status = status;
        this.completionTime = completionTime;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", completionTime=" + completionTime +
                ", user=" + user +
                '}';
    }
}