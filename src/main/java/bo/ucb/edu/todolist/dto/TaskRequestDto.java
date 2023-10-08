package bo.ucb.edu.todolist.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
//PD: si es necesario se hara 2 DTO, uno para cuando se crea una task y otro para cuando se completa


public class TaskRequestDto {
    private String taskName;
    private Timestamp dueDate;
    private Boolean status;
    private LocalDateTime completionTime;
    private Long labelId;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDateTime getDueDate() {
        return dueDate.toLocalDateTime();
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

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public TaskRequestDto() {

    }

    public TaskRequestDto(String taskName, Timestamp dueDate, Boolean status, LocalDateTime completionTime,Long labelId) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.status = status;
        this.completionTime = completionTime;
        this.labelId = labelId;
    }

    @Override
    public String toString() {
        return "TaskRequestDto{" +
                "taskName='" + taskName + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", completionTime=" + completionTime +
                '}';
    }
}
