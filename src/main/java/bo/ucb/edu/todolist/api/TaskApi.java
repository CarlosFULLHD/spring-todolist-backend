package bo.ucb.edu.todolist.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import bo.ucb.edu.todolist.bl.TaskBl;
import bo.ucb.edu.todolist.dto.TaskRequestDto;
import bo.ucb.edu.todolist.dto.TaskResponseDto;
import bo.ucb.edu.todolist.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskApi {

    private final Logger logger = LoggerFactory.getLogger(TaskApi.class);
    private final TaskBl taskBl;

    @Autowired
    public TaskApi(TaskBl taskBl) {
        this.taskBl = taskBl;
    }
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public List<TaskResponseDto> getAllTasks() {
        try {
            List<TaskResponseDto> tasks = taskBl.getAllTasks();
            List<TaskResponseDto> taskDtos = tasks.stream()
                    .map(task -> modelMapper.map(task, TaskResponseDto.class))
                    .collect(Collectors.toList());
            logger.info("Tareas obtenidas: " + taskDtos.toString());
            return taskDtos;
        } catch (RuntimeException ex) {
            logger.info("Error al obtener tareas: " + ex.getMessage());
            throw new RuntimeException("Error al obtener tareas");
        }
    }
    @GetMapping("/{taskId}")
    public TaskResponseDto getTaskById(@PathVariable Long taskId) {
        try {
            // Obtener la tarea por taskId
            TaskResponseDto task = taskBl.getTaskByIdAndUserId(taskId);

            // Verificar si la tarea existe y pertenece al usuario
            if (task == null) {
                logger.info("La tarea no existe o no pertenece al usuario.");
                throw new RuntimeException("La tarea no existe o no pertenece al usuario.");
            }

            logger.info("Obteniendo tarea por ID: " + taskId);
            return task;
        } catch (RuntimeException ex) {
            logger.info("Error al obtener la tarea con ID " + taskId + ": " + ex.getMessage());
            throw new RuntimeException("Error al obtener la tarea con ID " + taskId);
        }
    }

    @PostMapping("/")
    public ResponseDto addTask(@RequestBody TaskRequestDto taskRequestDto) {
        try {
            if (taskRequestDto.getCompletionTime() == null) {
                // Establecer el valor predeterminado como "ahora + 7 días"
                LocalDateTime defaultCompletionTime = LocalDateTime.now().plusDays(7);
                taskRequestDto.setCompletionTime(defaultCompletionTime);
            }
            TaskResponseDto task = taskBl.addTask(taskRequestDto);
            logger.info("Añadiendo tarea: " + taskRequestDto.getTaskName());
            return new ResponseDto("TASK-1000", "Tarea agregada correctamente");
        } catch (RuntimeException ex) {
            // Devolver un error con código y el mensaje
            logger.info("Error al crear la tarea: " + ex.getMessage());
            return new ResponseDto("TASK-1001", ex.getMessage());
        }
    }

    @PutMapping("/{taskId}")
    public ResponseDto editTask(@PathVariable Long taskId, @RequestBody TaskRequestDto taskRequestDto) {
        try {
            TaskResponseDto updatedTask = taskBl.editTask(taskId, taskRequestDto);
            logger.info("Tarea actualizada: " + updatedTask.getTaskName());
            return new ResponseDto("TASK-1000", "Tarea actualizada correctamente");
        } catch (RuntimeException ex) {
            logger.info("Error al actualizar la tarea con ID " + taskId + ": " + ex.getMessage());
            return new ResponseDto("TASK-1001", ex.getMessage());
        }
    }

    @DeleteMapping("/{taskId}")
    public ResponseDto deleteTask(@PathVariable Long taskId) {
        try {
            taskBl.deleteTask(taskId);
            logger.info("Tarea eliminada con ID: " + taskId);
            return new ResponseDto("TASK-1000", "Tarea eliminada correctamente");
        } catch (RuntimeException ex) {
            logger.info("Error al eliminar la tarea con ID " + taskId + ": " + ex.getMessage());
            return new ResponseDto("TASK-1001", ex.getMessage());
        }
    }
}
