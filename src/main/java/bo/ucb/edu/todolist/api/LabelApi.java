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
    @PostMapping("/")
    public ResponseDto addLabel(@RequestBody LabelRequestDto labelRequestDto){
        try {
            Label label = labelBl.addLabel(labelRequestDto);
            logger.info("Añadiendo etiqueta: " + labelRequestDto.getLabelName() + "De color: "+labelRequestDto.getLabelColor());
        }catch (RuntimeException ex){
            //Devolver un error con codigo y el mensaje
            logger.info("Error al crear el label: "+labelRequestDto.getLabelName(),labelRequestDto.getLabelColor());
            return new ResponseDto("LABEL-1001", "Error al agregar etiqueta");
        }
        //Cuando todo salga bien
        return new ResponseDto("LABEL-1000", "Etiqueta agregada correctamente");
    }
    // Método para obtener todas las etiquetas del usuario
    @GetMapping("/")
    public List<Label> getAllLabels() {
        try {
            List<Label> labels = labelBl.getAllLabels();
            logger.info("Etiquetas obtenidas: " + labels.toString());
            return labels;
        } catch (RuntimeException ex) {
            logger.info("Error al obtener etiquetas: " + ex.getMessage());
            throw new RuntimeException("Error al obtener etiquetas");
        }
    }
    // Método para editar una etiqueta por su ID
    @PutMapping("/{labelId}")
    public ResponseDto editLabel(@PathVariable Long labelId, @RequestBody LabelRequestDto labelRequestDto) {
        try {
            Label updatedLabel = labelBl.editLabel(labelId, labelRequestDto);
            logger.info("Etiqueta actualizada: " + updatedLabel.getLabelName() + " De color: " + updatedLabel.getLabelColor());
            return new ResponseDto("LABEL-1000", "Etiqueta actualizado correctamente");
        } catch (RuntimeException ex) {
            logger.info("Error al actualizar la etiqueta con ID " + labelId + ": " + ex.getMessage());
            return new ResponseDto("LABEL-1001", "Error al actualizar la etiqueta");
        }
    }
    // Método para eliminar una etiqueta por su ID
    @DeleteMapping("/{labelId}")
    public ResponseDto deleteLabel(@PathVariable Long labelId) {
        try {
            labelBl.deleteLabel(labelId);
            logger.info("Etiqueta eliminada con ID: " + labelId);
            return new ResponseDto("LABEL-1000", "Etiqueta eliminada correctamente");
        } catch (RuntimeException ex) {
            logger.info("Error al eliminar la etiqueta con ID " + labelId + ": " + ex.getMessage());
            return new ResponseDto("LABEL-1001", "Error al eliminar la etiqueta");
        }
    }

}


