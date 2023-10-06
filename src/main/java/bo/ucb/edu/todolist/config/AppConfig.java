package bo.ucb.edu.todolist.config;

import org.springframework.context.annotation.Configuration;

//Para guardar el id del usuario, para que no se pierda al momento de hacer el login
//V1, recomendable cambiar a otro metodo de autenticacion mas seguro porque esto NO ES NADA SEGURO
@Configuration
public class AppConfig {
    private static Long userId;

    public static Long getUserId() {
        return userId;
    }

    public static void setUserId(Long id) {
        userId = id;
    }
}
