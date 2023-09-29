package bo.ucb.edu.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "task_labels")
public class TaskLabel {
    @Id
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    private Task task;

    @Id
    @ManyToOne
    @JoinColumn(name = "label_id", referencedColumnName = "label_id")
    private Label label;

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

    public TaskLabel(Task task, Label label) {
        this.task = task;
        this.label = label;
    }

    @Override
    public String toString() {
        return "TaskLabel{" +
                "task=" + task +
                ", label=" + label +
                '}';
    }
}