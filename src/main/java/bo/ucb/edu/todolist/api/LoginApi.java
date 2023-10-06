package bo.ucb.edu.todolist.api;

import bo.ucb.edu.todolist.bl.SecurityBl;
import bo.ucb.edu.todolist.config.AppConfig;
import bo.ucb.edu.todolist.dto.LoginRequestDto;
import bo.ucb.edu.todolist.dto.ResponseDto;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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


    @PostMapping("/login")
    public ResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {

        try {
            securityBl.login(loginRequestDto.getUser(),
                    loginRequestDto.getPassword_hash());
            logger.info("Autenticando el usuario: " +
                    loginRequestDto.getUser(), "con contraseña: "
                    +loginRequestDto.getPassword_hash());
            // Devolver un mensaje de éxito
            return new ResponseDto("TASK-200", "Autenticado correctamente");
        } catch (RuntimeException ex) {
            //Devolver un error con codigo y el mensaje
            logger.info(loginRequestDto.getUser(), loginRequestDto.getPassword_hash());
            return new ResponseDto("TASK-1000", ex.getMessage());

        }
    }
    }




