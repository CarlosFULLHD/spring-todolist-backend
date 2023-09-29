package bo.ucb.edu.todolist.bl;

import bo.ucb.edu.todolist.dao.UserDao;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SecurityBl {
    private UserDao userDao;
    //Usando logger segun indicaciones del ing
    private final Logger logger = LoggerFactory.getLogger(SecurityBl.class);

    public SecurityBl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(String username, String passwordHash) {
        logger.info(username,passwordHash);
        User user = userDao.findByUsernameAndPasswordHash(username, passwordHash);

        if(user ==null){
            logger.warn("Autenticación incorrecta para el usuario: {}", username);
            throw new RuntimeException("Autenticacion incorrecta null");
        }
        //Para evitar que salga la contraseña, PERO es mejor que NUNCA SALGAN con mi DTO
        user.setPasswordHash(null);
        return user;


    }
}
