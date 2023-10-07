package bo.ucb.edu.todolist.dao;

import bo.ucb.edu.todolist.config.AppConfig;
import bo.ucb.edu.todolist.entity.Label;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelDao extends JpaRepository<Label, Long> {

    List<Label> findAllByUser_UserId(Long userId);


    Label findByLabelNameAndUser_UserId(String labelName, Long userId);

    Label findByIdAndUser_UserId(Long labelId, Long userId);
}
