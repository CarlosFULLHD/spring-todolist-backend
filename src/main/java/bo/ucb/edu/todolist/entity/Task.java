package bo.ucb.edu.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @NotBlank(message = "El nombre de la tarea no puede estar en blanco")
    @Column(name = "task_name", length = 255, nullable = false)
    private String taskName;

    @NotNull(message = "La fecha de vencimiento no puede ser nula")
    @Column(name = "due_date", nullable = false)
    private LocalDateTime dueDate;

    @NotNull(message = "El estado no puede ser nulo")
    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "completion_time")
    private LocalDateTime completionTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "label_id")
    private Label label;

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

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Task() {
    }

    public Task(Long taskId, String taskName, LocalDateTime dueDate, Boolean status, LocalDateTime completionTime, User user, Label label) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.status = status;
        this.completionTime = completionTime;
        this.user = user;
        this.label = label;
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
                ", label=" + label +
                '}';
    }
}



