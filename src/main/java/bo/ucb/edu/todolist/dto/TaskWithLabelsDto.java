package bo.ucb.edu.todolist.dto;

import java.util.Date;
import java.util.List;

public class TaskWithLabelsDto {
    private Long taskId;
    private String taskName;
    private boolean status;
    private Date dueDate;
    private List<String> labels; // Una lista de nombres de etiquetas

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public TaskWithLabelsDto() {
    }

    public TaskWithLabelsDto(Long taskId, String taskName, boolean status, Date dueDate, List<String> labels) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.dueDate = dueDate;
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "TaskWithLabelsDto{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status=" + status +
                ", dueDate=" + dueDate +
                ", labels=" + labels +
                '}';
    }
// Getters y setters
}