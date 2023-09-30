package bo.ucb.edu.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "task_labels")
public class TaskLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    private Task task;


    @ManyToOne
    @JoinColumn(name = "label_id", referencedColumnName = "label_id")
    private Label label;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TaskLabel(Long id, Task task, Label label) {
        this.id = id;
        this.task = task;
        this.label = label;
    }

    @Override
    public String toString() {
        return "TaskLabel{" +
                "id=" + id +
                ", task=" + task +
                ", label=" + label +
                '}';
    }
}