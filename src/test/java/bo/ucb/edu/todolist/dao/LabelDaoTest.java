/*
package bo.ucb.edu.todolist.dao;

import bo.ucb.edu.todolist.entity.Label;
import bo.ucb.edu.todolist.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class LabelDaoTest {

    @Autowired
    private LabelDao labelDao;

    @Test
    public void testFindByUserUserId() {
        // Crea un usuario y un conjunto de labels para el usuario en la base de datos
        User user = new User();
        // Configura los campos del usuario
        // ...

        Label label1 = new Label();
        // Configura los campos del label1 y asocia al usuario
        // ...

        Label label2 = new Label();
        // Configura los campos del label2 y asocia al usuario
        // ...

        // Guarda el usuario y los labels en la base de datos
        // ...

        // Llama al método que deseas probar
        List<Label> labels = labelDao.findByUserUserId(user.getUserId());

        // Realiza las aserciones
        assertThat(labels).hasSize(2); // Verifica que se hayan recuperado los dos labels asociados al usuario
        // Realiza más aserciones según tus necesidades
    }

    // Agrega más pruebas según sea necesario para otros métodos de LabelDao
}

*/
