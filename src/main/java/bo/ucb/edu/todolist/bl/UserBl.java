package bo.ucb.edu.todolist.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bo.ucb.edu.todolist.dao.UserDao;
import bo.ucb.edu.todolist.entity.User;

@Service
public class UserBl {
    private final UserDao userDao;
    private final Logger logger = LoggerFactory.getLogger(SecurityBl.class);

    @Autowired
    public UserBl(UserDao userDao) {
        this.userDao = userDao;
    }

    // Método para añadir un nuevo usuario
    @Transactional
    public User addUser(String username, String passwordHash) {
        // Verificar si el usuario ya existe
        if (userDao.findByUsername(username) != null) {
            logger.info("El usuario: " + username+ " ya existe.");
            throw new RuntimeException("El nombre de usuario ya está en uso.");
        }
        // Crear una nueva instancia de User y añadirlo
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPasswordHash(passwordHash);
        // Guardar el nuevo usuario en la base de datos
        logger.info("Añadiendo usuario: " + username);
        return userDao.save(newUser);
    }

    // Método para eliminar un usuario
    @Transactional
    public void deleteUser(Long userId) {
        userDao.deleteById(userId);
    }

    // Método para editar la contraseña de un usuario
    @Transactional
    public void editPassword(Long userId, String username, String passwordHash) {
            // Buscar al usuario por su ID
            User user = userDao.findByuserId(userId);
            if (user == null) {
                logger.info("El usuario no existe: {}", username);
                throw new IllegalArgumentException("El usuario no existe");
            }

            // Actualizar la contraseña en el objeto usuario
            user.setPasswordHash(passwordHash);

            // Guardar los cambios en la base de datos
            userDao.save(user);

    }

}
