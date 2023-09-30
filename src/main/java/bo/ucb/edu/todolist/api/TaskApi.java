package bo.ucb.edu.todolist.api;

import bo.ucb.edu.todolist.bl.LabelBl;
import bo.ucb.edu.todolist.bl.TaskBl;
import bo.ucb.edu.todolist.dto.ResponseDto;
import bo.ucb.edu.todolist.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskApi {
    private final TaskBl taskBl;
    private final Logger logger = LoggerFactory.getLogger(LabelBl.class);

    @Autowired
    public TaskApi(TaskBl taskBl) {
        this.taskBl = taskBl;
    }

    // Obtener todas las tareas
    @GetMapping("/")
    public List<Task> getAllTasks() {
        return taskBl.getAllTasks();
    }

    // Crear una tarea
    @PostMapping("/")
    public ResponseDto addTask(@RequestBody Task task) {
        try {
            Task addedTask = taskBl.addTask(task); // No se asignan etiquetas en este punto
            return new ResponseDto("Tarea creada con éxito.", addedTask);
        } catch (Exception ex) {
            return new ResponseDto("ERROR", ex.getMessage());
        }
    }

    // Editar una tarea
    @PutMapping("/{taskId}")
    public ResponseDto editTask(@PathVariable Long taskId, @RequestBody Task task) {
        try {
            task.setTaskId(taskId);
            Task updatedTask = taskBl.editTask(task); // No se editan etiquetas en este punto
            return new ResponseDto("Tarea editada con éxito.", updatedTask);
        } catch (Exception ex) {
            return new ResponseDto("ERROR", ex.getMessage());
        }
    }

    // Eliminar una tarea
    @DeleteMapping("/{taskId}")
    public ResponseDto deleteTask(@PathVariable Long taskId) {
        try {
            taskBl.deleteTask(taskId);
            return new ResponseDto("Tarea eliminada con éxito.");
        } catch (Exception ex) {
            return new ResponseDto("ERROR", ex.getMessage());
        }
    }
    // Cambiar el estado de una tarea a true
    @PutMapping("/complete/{taskId}")
    public ResponseDto completeTask(@PathVariable Long taskId) {
        try {
            Task task = taskBl.getTaskById(taskId); // Obtener la tarea por su ID
            if (task == null) {
                return new ResponseDto("ERROR", "La tarea no existe.");
            }

            task.setStatus(true); // Cambiar el estado a true
            Task updatedTask = taskBl.editTask(task); // Guardar la tarea actualizada

            return new ResponseDto("Tarea completada con éxito.", updatedTask);
        } catch (Exception ex) {
            return new ResponseDto("ERROR", ex.getMessage());
        }
    }

}
