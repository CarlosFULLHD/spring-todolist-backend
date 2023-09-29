package bo.ucb.edu.todolist;

import bo.ucb.edu.todolist.dao.UserDao;
import bo.ucb.edu.todolist.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodolistApplicationTests {

	//Para que spring me de a lo que le di el control
	@Autowired
	UserDao userDao;
	@Test
	void contextLoads() {
		List<User> userList = userDao.findAll();
		for (User u : userList){
			System.out.println(u.getUsername());
		}
		assertNotEquals(0,userList.size(),
				"Autenticacion incorrecta");

	}

}
