package bo.ucb.edu.todolist.dao;

import bo.ucb.edu.todolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password_hash = :password_hash")
    User findByUsernameAndPasswordHash(@Param("username") String username, @Param("password_hash") String passwordHash);
}

