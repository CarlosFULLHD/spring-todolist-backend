package bo.ucb.edu.todolist.bl;


import bo.ucb.edu.todolist.dao.LabelDao;
import bo.ucb.edu.todolist.entity.Label;
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
    public LabelBl(LabelDao labelDao) {
        this.labelDao = labelDao;
    }

    // Método para obtener todas las etiquetas
    public List<Label> getAllLabels() {
        return labelDao.findAll();
    }

    // Método para añadir un nuevo label
    @Transactional
    public Label addLabel(String labelName) {
        // Verificar si el label ya existe
        if (labelDao.findByLabelName(labelName) != null) {
            throw new RuntimeException("El nombre de etiqueta ya está en uso.");
        }

        // Crear una nueva instancia de Label y añadirla
        Label newLabel = new Label();
        newLabel.setLabelName(labelName);

        // Guardar el nuevo label en la base de datos
        return labelDao.save(newLabel);
    }

    // Método para eliminar un label
    @Transactional
    public void deleteLabel(Long labelId) {
        labelDao.deleteById(labelId);
    }

    // Método para editar un label
    @Transactional
    public void editLabel(Long labelId, String labelName) {
        // Buscar el label por su ID
        Label label = labelDao.findById(labelId).orElse(null);
        if (label == null) {
            throw new IllegalArgumentException("El label no existe");
        }
        // Actualizar el nombre del label
        label.setLabelName(labelName);
        // Guardar los cambios en la base de datos
        labelDao.save(label);
    }


}

