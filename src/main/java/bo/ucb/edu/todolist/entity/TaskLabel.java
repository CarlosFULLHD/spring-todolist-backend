package bo.ucb.edu.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;


@Entity
@Table(name = "task_labels")
public class TaskLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_label_id")
    private Long taskLabelId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "label_id")
    private Label label;

    // Getters and setters


    public Long getTaskLabelId() {
        return taskLabelId;
    }

    public void setTaskLabelId(Long taskLabelId) {
        this.taskLabelId = taskLabelId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TaskLabel() {
    }

    public TaskLabel(Long taskLabelId, Task task, Label label) {
        this.taskLabelId = taskLabelId;
        this.task = task;
        this.label = label;
    }

    @Override
    public String toString() {
        return "TaskLabel{" +
                "taskLabelId=" + taskLabelId +
                ", task=" + task +
                ", label=" + label +
                '}';
    }
}

