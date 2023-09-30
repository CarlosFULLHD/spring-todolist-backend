package bo.ucb.edu.todolist.dto;


public class TaskLabelRequestDto {
    private Long task;
    private Long label;

    public Long getTask() {
        return task;
    }

    public void setTask(Long task) {
        this.task = task;
    }

    public Long getLabel() {
        return label;
    }

    public void setLabel(Long label) {
        this.label = label;
    }

    public TaskLabelRequestDto() {

    }

    public TaskLabelRequestDto(Long task, Long label) {
        this.task = task;
        this.label = label;
    }

    @Override
    public String toString() {
        return "TaskLabelRequestDto{" +
                "task=" + task +
                ", label=" + label +
                '}';
    }
}
