package bo.ucb.edu.todolist.dao;

import bo.ucb.edu.todolist.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelDao extends JpaRepository<Label, Long> {


    Label findByLabelName(String labelName);
}
