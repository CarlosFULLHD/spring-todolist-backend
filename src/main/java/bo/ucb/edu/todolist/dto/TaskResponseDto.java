package bo.ucb.edu.todolist.dto;

import bo.ucb.edu.todolist.entity.Label;
import bo.ucb.edu.todolist.entity.Task;

import java.time.LocalDateTime;

public class TaskResponseDto {
    private Long taskId;
    private String taskName;
    private LocalDateTime dueDate;
    private Boolean status;
    private LocalDateTime completionTime;
    private LabelResponseDto label;

    public TaskResponseDto() {
    }

    public TaskResponseDto(Long taskId, String taskName, LocalDateTime dueDate, Boolean status, LocalDateTime completionTime, LabelResponseDto label) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.status = status;
        this.completionTime = completionTime;
        this.label = label;
    }

    public TaskResponseDto(Task task) {
        this.taskId = task.getTaskId();
        this.taskName = task.getTaskName();
        this.dueDate = task.getDueDate();
        this.status = task.getStatus();
        this.completionTime = task.getCompletionTime();

        if (task.getLabel() != null) {
            this.label = new LabelResponseDto(task.getLabel());
        }
    }

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

    public LabelResponseDto getLabel() {
        return label;
    }

    public void setLabel(LabelResponseDto label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "TaskResponseDto{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", completionTime=" + completionTime +
                ", label=" + label +
                '}';
    }
}
