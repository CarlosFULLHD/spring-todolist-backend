package bo.ucb.edu.todolist.api;

import bo.ucb.edu.todolist.bl.SecurityBl;
import bo.ucb.edu.todolist.dto.LoginRequestDto;
import bo.ucb.edu.todolist.dto.ResponseDto;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1")
public class LoginApi {
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

    @PostMapping("api/v1/login")
    public ResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        User user;
        try {
            user = securityBl.login(loginRequestDto.getUser(),loginRequestDto.getPassword_hash());

        }catch (RuntimeException ex){
            return new ResponseDto("TASK-1000", ex.getMessage());

        }
        return new ResponseDto(user);

    }


}
