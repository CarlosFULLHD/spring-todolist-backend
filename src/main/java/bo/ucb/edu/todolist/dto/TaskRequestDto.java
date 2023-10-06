package bo.ucb.edu.todolist.dto;

import bo.ucb.edu.todolist.entity.User;

import java.sql.Timestamp;
//PD: si es necesario se hara 2 DTO, uno para cuando se crea una task y otro para cuando se completa


public class TaskRequestDto {
    private String taskName;
    private Timestamp dueDate;
    private Boolean status;
    private Timestamp completionTime;

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


    public TaskRequestDto() {
    }

    public TaskRequestDto(String taskName, Timestamp dueDate, Boolean status, Timestamp completionTime) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.status = status;
        this.completionTime = completionTime;
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
