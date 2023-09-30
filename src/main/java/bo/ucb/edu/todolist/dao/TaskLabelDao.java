package bo.ucb.edu.todolist.dao;

import bo.ucb.edu.todolist.entity.Task;
import bo.ucb.edu.todolist.entity.Label;
import bo.ucb.edu.todolist.entity.TaskLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskLabelDao extends JpaRepository<TaskLabel, Long> {
    TaskLabel findByTaskAndLabel(Task task, Label label);
}