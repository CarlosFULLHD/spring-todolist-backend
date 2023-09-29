package bo.ucb.edu.todolist.dao;

import bo.ucb.edu.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    // Método personalizado para verificar el inicio de sesión por nombre de usuario y contraseña
    User findByUsernameAndPasswordHash(String username, String passwordHash);
    // Método personalizado para buscar un usuario por nombre de usuario
    //User findByUsername(String username);

    // Método personalizado para actualizar la contraseña de un usuario
    //void updateUserPasswordByUsername(String username, String newPasswordHash);

    // Método personalizado para eliminar un usuario por nombre de usuario
    //void deleteUserByUsername(String username);
}

