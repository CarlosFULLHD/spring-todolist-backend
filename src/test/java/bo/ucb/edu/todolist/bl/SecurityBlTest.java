package bo.ucb.edu.todolist.bl;

import bo.ucb.edu.todolist.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SecurityBlTest {

    @Autowired
    SecurityBl securityBl;

    @Test
    void testLOgin(){
        User user =securityBl.login("Bruno","passwordhash1");
        assertNotNull(user, "Autenticacion incorrecta");
    }
    @Test
    void ErrorLOgin(){
        try{
            securityBl.login("Bruno","passwordhash1");
        }catch (RuntimeException ex){
            assertEquals("Autenticacion incorrecta",
                    ex.getMessage());
        }

    }


}