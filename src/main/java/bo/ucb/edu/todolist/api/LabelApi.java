package bo.ucb.edu.todolist.api;

import bo.ucb.edu.todolist.bl.LabelBl;
import bo.ucb.edu.todolist.bl.SecurityBl;
import bo.ucb.edu.todolist.dto.LabelRequestDto;
import bo.ucb.edu.todolist.dto.LoginRequestDto;
import bo.ucb.edu.todolist.dto.ResponseDto;
import bo.ucb.edu.todolist.entity.Label;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@RestController
@RequestMapping("api/v1/labels")
public class LabelApi {
    private final Logger logger = LoggerFactory.getLogger(LabelApi.class);
    private final LabelBl labelBl;

    @Autowired
    public LabelApi(LabelBl labelBl) {
        this.labelBl = labelBl;
    }

    // Crear un label
    @PostMapping("/")
    public ResponseDto addLabel(@RequestBody LabelRequestDto labelRequestDto) {
        try {
            Label label = labelBl.addLabel(labelRequestDto.getLabelName());
            logger.info("Añadiendo label: " + labelRequestDto.getLabelName());
            return new ResponseDto(label);
        } catch (RuntimeException ex) {
            logger.warn("Error al añadir label: " + ex.getMessage());
            return new ResponseDto("TASK-1000", ex.getMessage());
        }
    }

    // Editar un label
    @PutMapping("/{labelId}")
    public ResponseDto editLabel(@PathVariable Long labelId, @RequestBody LabelRequestDto labelRequestDto) {
        try {
            labelBl.editLabel(labelId, labelRequestDto.getLabelName());
            logger.info("Label actualizado con éxito para el label: " + labelId);
            return new ResponseDto("Label actualizado con éxito.");
        } catch (RuntimeException ex) {
            logger.warn("Error al actualizar Label: " + ex.getMessage());
            return new ResponseDto("TASK-1002", ex.getMessage());
        }
    }

    // Eliminar un label
    @DeleteMapping("/{labelId}")
    public ResponseDto deleteLabel(@PathVariable Long labelId) {
        try {
            labelBl.deleteLabel(labelId);
            logger.info("Label eliminado con éxito: " + labelId);
            return new ResponseDto("Label eliminado con éxito.");
        } catch (RuntimeException ex) {
            logger.warn("Error al eliminar label: " + ex.getMessage());
            return new ResponseDto("TASK-1001", ex.getMessage());
        }
    }

    // Obtener todas las etiquetas
    @GetMapping("/")
    public List<Label> getAllLabels() {
        return labelBl.getAllLabels();
    }
}


