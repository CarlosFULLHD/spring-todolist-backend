package bo.ucb.edu.todolist.bl;

import bo.ucb.edu.todolist.dao.UserDao;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityBl {
    private UserDao userDao;

    public SecurityBl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(String username, String passwordHash) {
        User user = userDao.findByUsernameAndPasswordHash(username, passwordHash);
        if( user ==null){
            throw new RuntimeException("Autenticacion incorrecta");
        }
        return user;


    }
}
