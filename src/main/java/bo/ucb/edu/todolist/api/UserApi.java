package bo.ucb.edu.todolist.api;

import bo.ucb.edu.todolist.bl.SecurityBl;
import bo.ucb.edu.todolist.bl.UserBl;
import bo.ucb.edu.todolist.dto.LoginRequestDto;
import bo.ucb.edu.todolist.dto.ResponseDto;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@RestController
@RequestMapping("api/v1")
public class UserApi {
    private final Logger logger = LoggerFactory.getLogger(SecurityBl.class);
    @Autowired
    UserBl userBl;
    @Autowired
    public UserApi(UserBl userBl) {
        this.userBl = userBl;
    }

    @PostMapping("/login/newuser")
    public ResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        User user;
        try {
            user = userBl.addUser(loginRequestDto.getUser(),
                    loginRequestDto.getPassword_hash());
            logger.info("Autenticado el usuario: "+loginRequestDto.getUser(),loginRequestDto.getPassword_hash());
        }catch (RuntimeException ex){
            //Devolver un error con codigo y el mensaje
            logger.warn(loginRequestDto.getUser(),loginRequestDto.getPassword_hash());
            return new ResponseDto("TASK-1000", ex.getMessage());

        }
        //Cuando todo salga bien
        return new ResponseDto(user);

    }


}

