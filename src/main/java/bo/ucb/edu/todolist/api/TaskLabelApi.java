package bo.ucb.edu.todolist.api;

import bo.ucb.edu.todolist.bl.TaskLabelBl;
import bo.ucb.edu.todolist.dto.ResponseDto;
import bo.ucb.edu.todolist.entity.TaskLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/task-labels")
public class TaskLabelApi {
    private final TaskLabelBl taskLabelBl;

    @Autowired
    public TaskLabelApi(TaskLabelBl taskLabelBl) {
        this.taskLabelBl = taskLabelBl;
    }

    // Obtener todas las relaciones entre tareas y etiquetas
    @GetMapping("/")
    public List<TaskLabel> getAllTaskLabels() {
        return taskLabelBl.getAllTaskLabels();
    }

    // Crear una relación entre tarea y etiqueta
    @PostMapping("/")
    public ResponseDto addTaskLabel(@RequestBody TaskLabel taskLabel) {
        try {
            TaskLabel addedTaskLabel = taskLabelBl.addTaskLabel(taskLabel);
            return new ResponseDto("Relación entre tarea y etiqueta creada con éxito.", String.valueOf(addedTaskLabel));
        } catch (Exception ex) {
            return new ResponseDto("ERROR", ex.getMessage());
        }
    }

    // Modificar una relación entre tarea y etiqueta por ID
    @PutMapping("/{taskLabelId}")
    public ResponseDto editTaskLabel(@PathVariable Long taskLabelId, @RequestBody TaskLabel updatedTaskLabel) {
        try {
            TaskLabel editedTaskLabel = taskLabelBl.editTaskLabel(taskLabelId, updatedTaskLabel);
            return new ResponseDto("Relación entre tarea y etiqueta modificada con éxito.", String.valueOf(editedTaskLabel));
        } catch (Exception ex) {
            return new ResponseDto("ERROR", ex.getMessage());
        }
    }
    // Eliminar una relación entre tarea y etiqueta
    @DeleteMapping("/{taskLabelId}")
    public ResponseDto deleteTaskLabel(@PathVariable Long taskLabelId) {
        try {
            taskLabelBl.deleteTaskLabel(taskLabelId);
            return new ResponseDto("Relación entre tarea y etiqueta eliminada con éxito.");
        } catch (Exception ex) {
            return new ResponseDto("ERROR", ex.getMessage());
        }
    }
}
