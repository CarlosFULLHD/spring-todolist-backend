package bo.ucb.edu.todolist.api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import bo.ucb.edu.todolist.bl.LabelBl;
import bo.ucb.edu.todolist.bl.SecurityBl;
import bo.ucb.edu.todolist.dto.LabelRequestDto;
import bo.ucb.edu.todolist.dto.LabelResponseDto;
import bo.ucb.edu.todolist.dto.LoginRequestDto;
import bo.ucb.edu.todolist.dto.ResponseDto;
import bo.ucb.edu.todolist.entity.Label;
import bo.ucb.edu.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/labels")
public class LabelApi {

    private final Logger logger = LoggerFactory.getLogger(LabelApi.class);
    private final LabelBl labelBl;

    @Autowired
    public LabelApi(LabelBl labelBl) {
        this.labelBl = labelBl;
    }
    @Autowired
    private ModelMapper modelMapper;
    // Crear un label
    @PostMapping("/")//{userId} como se guarda en una variable el userId no se requiere en el request body
    public ResponseDto addLabel(@RequestBody LabelRequestDto labelRequestDto){
        try {
            LabelResponseDto label = labelBl.addLabel(labelRequestDto);
            logger.info("Añadiendo etiqueta: " + labelRequestDto.getLabelName() + " de color: "+labelRequestDto.getLabelColor());
        }catch (RuntimeException ex){
            //Devolver un error con codigo y el mensaje
            logger.info("Error al crear el label: "+labelRequestDto.getLabelName(),labelRequestDto.getLabelColor());
            return new ResponseDto("LABEL-1001", ex.getMessage());
        }
        //Cuando todo salga bien
        return new ResponseDto("LABEL-1000", "Etiqueta agregada correctamente");
    }

@GetMapping("/")
public List<LabelResponseDto> getAllLabels() {
    try {
        List<LabelResponseDto> labels = labelBl.getAllLabels();
        List<LabelResponseDto> labelDtos = labels.stream()
                .map(label -> modelMapper.map(label, LabelResponseDto.class))
                .collect(Collectors.toList());
        logger.info("Etiquetas obtenidas: " + labelDtos.toString());
        return labelDtos;
    } catch (RuntimeException ex) {
        logger.info("Error al obtener etiquetas: " + ex.getMessage());
        throw new RuntimeException("Error al obtener etiquetas");
    }
}


    // Método para editar una etiqueta por su ID
    @PutMapping("/{labelId}")
    public ResponseDto editLabel(@PathVariable Long labelId, @RequestBody LabelRequestDto labelRequestDto) {
        try {
            LabelResponseDto updatedLabel = labelBl.editLabel(labelId, labelRequestDto);
            logger.info("Etiqueta actualizada: " + updatedLabel.getLabelName() + " de color: " + updatedLabel.getLabelColor());
            return new ResponseDto("LABEL-1000", "Etiqueta actualizada correctamente");
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


