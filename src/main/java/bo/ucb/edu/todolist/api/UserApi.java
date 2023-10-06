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
@RequestMapping("api/v1/users")
public class UserApi {
    private final Logger logger = LoggerFactory.getLogger(SecurityBl.class);
    @Autowired
    UserBl userBl;
    @Autowired
    public UserApi(UserBl userBl) {
        this.userBl = userBl;
    }

    //Añadir nuevo usuario
    @PostMapping("/")
    public ResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        try {
            User user = userBl.addUser(loginRequestDto.getUser(), loginRequestDto.getPassword_hash());
            logger.info("Añadiendo usuario: " + loginRequestDto.getUser());
        }catch (RuntimeException ex){
            //Devolver un error con codigo y el mensaje
            logger.warn(loginRequestDto.getUser(),loginRequestDto.getPassword_hash());
            return new ResponseDto("TASK-1001", "Error al agregar usuario");
        }
        //Cuando todo salga bien
        return new ResponseDto("TASK-1000", "Usuario agregado correctamente");
    }

//Editar usuario existente por ID
    @PutMapping("/{userId}")
    public ResponseDto editPassword(@PathVariable Long userId, @RequestBody LoginRequestDto loginRequestDto) {
        try {
            userBl.editPassword(userId, loginRequestDto.getUser(), loginRequestDto.getPassword_hash());
            logger.info("Contraseña actualizada con éxito para el usuario: " + userId);
            return new ResponseDto("Contraseña actualizada con éxito.");
        } catch (RuntimeException ex) {
            logger.warn("Error al actualizar contraseña para el usuario " + userId + ": " + ex.getMessage(), ex);
            return new ResponseDto("TASK-1002", ex.getMessage());
        }
    }
    //Eliminar usuario existente por ID
    @DeleteMapping("/{userId}")
    public ResponseDto deleteUser(@PathVariable Long userId) {
        try {
            userBl.deleteUser(userId);
            logger.info("Usuario eliminado con éxito: " + userId);
            return new ResponseDto("Usuario eliminado con éxito.");
        } catch (RuntimeException ex) {
            logger.warn("Error al eliminar usuario " + userId + ": " + ex.getMessage(), ex);
            return new ResponseDto("TASK-1001", ex.getMessage());
        }
    }
}

