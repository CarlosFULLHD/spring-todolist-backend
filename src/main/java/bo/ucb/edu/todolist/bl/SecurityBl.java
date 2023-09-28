package bo.ucb.edu.todolist.bl;

import bo.ucb.edu.todolist.dao.UserDao;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.stereotype.Service;

@Service
public class SecurityBl {

    private UserDao userDao;

    public SecurityBl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(String username, String password_hash){
        User user = userDao.findByUsernameAndPasswordHash(username, password_hash);
        if(user==null){
            throw new RuntimeException("invalid authentication");
        }
        user.setPasswordHash(null);
        return user;
    }

}
