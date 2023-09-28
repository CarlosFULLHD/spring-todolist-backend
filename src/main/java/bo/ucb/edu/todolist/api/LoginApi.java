package bo.ucb.edu.todolist.api;

import bo.ucb.edu.todolist.bl.SecurityBl;
import bo.ucb.edu.todolist.dto.LoginRequestDto;
import bo.ucb.edu.todolist.dto.ResponseDto;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class LoginApi {
    public ResponseDto login(){
        List<Tasks> tasks = new ArrayList<>();
        return new ResponseDto(tasks);
    }

    SecurityBl securityBl;

    public LoginApi(SecurityBl securityBl) {
        this.securityBl = securityBl;
    }

    @PostMapping("api/v1/login")
    public ResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        User user;
        try {
            user = securityBl.login(loginRequestDto.getUser(),loginRequestDto.getpassword());

        }catch (RuntimeException ex){
            return new ResponseDto("TASK-1000", ex.getMessage());

        }
        return new ResponseDto(user);

    }


}
