package bo.ucb.edu.todolist.dao;

import bo.ucb.edu.todolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends JpaRepository<Task, Long> {


    @Query("SELECT t FROM Task t WHERE t.user.userId = :userId")
    List<Task> findAllTasksByUserId(@Param("userId") Long userId);

}
