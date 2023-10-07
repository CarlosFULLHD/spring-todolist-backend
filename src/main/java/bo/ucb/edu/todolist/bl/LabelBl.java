package bo.ucb.edu.todolist.bl;


import bo.ucb.edu.todolist.config.AppConfig;
import bo.ucb.edu.todolist.dao.LabelDao;
import bo.ucb.edu.todolist.dto.LabelRequestDto;
import bo.ucb.edu.todolist.entity.Label;
import bo.ucb.edu.todolist.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class LabelBl {

    private final LabelDao labelDao;
    private final Logger logger = LoggerFactory.getLogger(LabelBl.class);
    @Autowired
    private AppConfig appConfig;
    @Autowired
    public LabelBl(LabelDao labelDao) {
        this.labelDao = labelDao;
    }
    
    // Método para obtener todas las etiquetas de un usuario
    public List<Label> getAllLabels() {
        Long userId = appConfig.getUserId();
        //OBTENER TODOS LOS LABELS de userId guardado en appConfig
        //Verificar que userId no sea 0, null o genere un error
        if(userId == null || userId == 0){
            logger.info("Usuario no valido: " + userId);
            throw new RuntimeException("El usuario no está logueado");
        }
        List<Label> labels = labelDao.findAllByUser_UserId(userId);
        logger.info("Etiquetas obtenidas obtenidos: "+labels.toString());
        return labels;
    }

    // Método para añadir un nuevo label para un usuario
    @Transactional
    public Label addLabel(LabelRequestDto labelRequestDto) {
        Long userId = appConfig.getUserId();
        // Verificar si el label ya existe para el usuario
        Label existingLabel = labelDao.findByLabelNameAndUser_UserId(labelRequestDto.getLabelName(), userId);
        if (existingLabel != null) {
            logger.info("El nombre de la etiqueta"+ existingLabel + "ya está en uso para este usuario.");
            throw new RuntimeException("El nombre de etiqueta ya está en uso para este usuario.");
        }
        // Obtener el usuario por su ID
        User user = new User(userId);
        // Crear una nueva etiqueta y asignarle los valores del DTO
        Label label = new Label();
        label.setLabelName(labelRequestDto.getLabelName());
        label.setLabelColor(labelRequestDto.getLabelColor());
        // Asignar el usuario a la etiqueta
        label.setUser(user);
        logger.info("Label creado: "+label.toString());
        // Guardar la etiqueta en la base de datos
        return labelDao.save(label);
    }

    // Método para eliminar un label de un usuario
    @Transactional
    public void deleteLabel(Long labelId) {
        Long userId = appConfig.getUserId();
        Label label = labelDao.findByIdAndUser_UserId(labelId, userId);
        if (label == null) {
            logger.info("La etiqueta no existe para este usuario.");
            throw new RuntimeException("La etiqueta no existe para este usuario.");
        }
        logger.info("Label eliminado: "+label.toString());
        labelDao.deleteById(labelId);
    }

    // Método para editar un label de un usuario
    @Transactional
    public Label editLabel(Long labelId, LabelRequestDto labelRequestDto) {
        Long userId = appConfig.getUserId();
        Label label = labelDao.findByIdAndUser_UserId(labelId, userId);
        if (label == null) {
            logger.info("La etiqueta no existe para este usuario.");
            throw new RuntimeException("La etiqueta no existe para este usuario.");
        }
        // Actualizar los valores de la etiqueta con los del DTO
        label.setLabelName(labelRequestDto.getLabelName());
        label.setLabelColor(labelRequestDto.getLabelColor());
        logger.info("Etiqueta actualizada : "+label.toString());
        // Guardar la etiqueta actualizada en la base de datos
        return labelDao.save(label);
    }

}
