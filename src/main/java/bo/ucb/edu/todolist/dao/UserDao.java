package bo.ucb.edu.todolist.dao;

import bo.ucb.edu.todolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    // Método personalizado para verificar el inicio de sesión por nombre de usuario y contraseña
    User findByUsernameAndPasswordHash(String username, String passwordHash);
    //Metodo para encontrar el nombre y asi verificar que no haya duplicado
    //Asi no morstrar el error sql statement
    User findByUsername(String username);

    User findByuserId(Long userId);
}

