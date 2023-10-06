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
@RequestMapping("/api/v1/user/{userId}/labels")
public class LabelApi {

    private final Logger logger = LoggerFactory.getLogger(LabelApi.class);
    private final LabelBl labelBl;

    @Autowired
    public LabelApi(LabelBl labelBl) {
        this.labelBl = labelBl;
    }

    // Crear un label
    @PostMapping
    public ResponseEntity<Label> addLabel(@PathVariable Long userId, @RequestBody LabelRequestDto labelRequestDto) {
        try {
            Label label = labelBl.addLabel(userId, labelRequestDto);
            logger.info("Añadiendo label: " + labelRequestDto.getLabelName());
            return new ResponseDto("TASK-1000", "Usuario agregado correctamente");
        } catch (RuntimeException ex) {
            logger.warn("Error al añadir label: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Editar un label
    @PutMapping("/{labelId}")
    public ResponseEntity<Label> editLabel(@PathVariable Long userId, @PathVariable Long labelId,  @RequestBody LabelRequestDto labelRequestDto) {
        try {
            Label label = labelBl.editLabel(userId, labelId, labelRequestDto);
            logger.info("Label actualizado con éxito para el label: " + labelId);
            return new ResponseEntity<>(label, HttpStatus.OK);
        } catch (RuntimeException ex) {
            logger.warn("Error al actualizar Label: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Eliminar un label
    @DeleteMapping("/{labelId}")
    public ResponseEntity<Void> deleteLabel(@PathVariable Long userId, @PathVariable Long labelId) {
        try {
            labelBl.deleteLabel(userId, labelId);
            logger.info("Label eliminado con éxito: " + labelId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException ex) {
            logger.warn("Error al eliminar label: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Obtener todas las etiquetas
    @GetMapping
    public ResponseEntity<List<Label>> getAllLabels(@PathVariable Long userId) {
        List<Label> labels = labelBl.getAllLabels(userId);
        return new ResponseEntity<>(labels, HttpStatus.OK);
    }
}


