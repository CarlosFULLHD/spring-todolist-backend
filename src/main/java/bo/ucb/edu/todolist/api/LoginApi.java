package bo.ucb.edu.todolist.api;

import bo.ucb.edu.todolist.bl.SecurityBl;
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
public class LoginApi {
    private final Logger logger = LoggerFactory.getLogger(SecurityBl.class);
    @Autowired
    SecurityBl securityBl;
    @Autowired
    public LoginApi(SecurityBl securityBl) {
        this.securityBl = securityBl;
    }

/*
    @GetMapping("/tasks")
    public ResponseDto getTasks() {
        return new ResponseDto(new ArrayList<>()); // Esto crea una lista vacía de tareas
    }*/

    @PostMapping("/login")
    public ResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        User user;
        try {

            user = securityBl.login(loginRequestDto.getUser(),
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
