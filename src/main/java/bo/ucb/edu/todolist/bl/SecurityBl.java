package bo.ucb.edu.todolist.bl;

import bo.ucb.edu.todolist.config.AppConfig;
import bo.ucb.edu.todolist.dao.UserDao;
import bo.ucb.edu.todolist.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SecurityBl {
    private UserDao userDao;
    @Autowired
    private AppConfig appConfig;
    private final Logger logger = LoggerFactory.getLogger(SecurityBl.class);

    public SecurityBl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void login(String username, String passwordHash) {
        logger.info(username,passwordHash);

        //Verificar username y passwordHash sean correctos con los de LoginRequestDto
        User user = userDao.findByUsernameAndPasswordHash(username, passwordHash);
        //Si el usuario no existe
        if(user ==null){
            logger.info("Autenticación incorrecta");
            throw new RuntimeException("Autenticacion incorrecta");
        }
        logger.info("Autenticación correcta");
        // Configura el userId en AppConfig
        appConfig.setUserId(user.getUserId());
        // Verificar que el userId se haya configurado correctamente
        Long configuredUserId = appConfig.getUserId();
        logger.info("userId configurado en AppConfig: " + configuredUserId);



    }
}
