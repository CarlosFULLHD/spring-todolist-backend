package bo.ucb.edu.todolist.dao;

import bo.ucb.edu.todolist.config.AppConfig;
import bo.ucb.edu.todolist.dto.LabelRequestDto;
import bo.ucb.edu.todolist.entity.Label;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface LabelDao extends JpaRepository<Label, Long> {

    //LabelRequestDto<Label> findAllByUser_UserId(Long userId);
    //Label findByLabelNameAndUser_UserId(String labelName, Long userId);
    //Label findByIdAndUser_UserId(Long labelId, Long userId);

    // Consulta para obtener todos los labels de un usuario por su user_id
    @Query("SELECT l FROM Label l WHERE l.user.userId = :userId")
    List<Label> findAllLabelsByUserId(@Param("userId") Long userId);

    // Consulta para obtener un label por su nombre y el id del usuario
    @Query("SELECT l FROM Label l WHERE l.labelName = :labelName AND l.user.userId = :userId")
    Label findLabelByNameAndUserId(@Param("labelName") String labelName, @Param("userId") Long userId);

    // Consulta para obtener un label por su id y el id del usuario
    @Query("SELECT l FROM Label l WHERE l.labelId = :labelId AND l.user.userId = :userId")
    Label findLabelByIdAndUserId(@Param("labelId") Long labelId, @Param("userId") Long userId);
}