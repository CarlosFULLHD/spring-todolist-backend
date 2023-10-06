//package bo.ucb.edu.todolist.dao;
//
//import bo.ucb.edu.todolist.entity.Label;
//import bo.ucb.edu.todolist.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface LabelDao extends JpaRepository<Label, Long> {
//
//
//    List<Label> findByUserUserId(Long userId);
//    Label findByLabelNameAndUserId(String labelName, Long userId);
//
//    Label findByIdAndUserId(Long labelId, Long userId);
//}
