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

    public User login(String user, String hash){
        User=user.findByuserAndpassword_hash
        if(user==null){
            throw new RuntimeException("THe user doesn't exist");

        }
        user.setpasswordhash(null);
        return user;
    }

}
