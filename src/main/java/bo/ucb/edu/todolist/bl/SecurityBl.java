package bo.ucb.edu.todolist.bl;

import bo.ucb.edu.todolist.dao.UserDao;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityBl {
    private UserDao userDao;

    @Autowired
    public SecurityBl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(String username, String password) {
        Optional<User> userOptional = userDao.findByUsernameAndPasswordHash(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Verificar si la contraseña coincide
            if (user.getPasswordHash().equals(password)) {
                return user; // Devolver el usuario en caso de autenticación exitosa
            }
        }

        return null; // Devolver null si la autenticación falla o el usuario no existe
    }
}
