package bo.ucb.edu.todolist.bl;

import bo.ucb.edu.todolist.config.AppConfig;
import bo.ucb.edu.todolist.dao.LabelDao;
import bo.ucb.edu.todolist.dao.TaskDao;
import bo.ucb.edu.todolist.dao.UserDao;
import bo.ucb.edu.todolist.dto.LabelRequestDto;
import bo.ucb.edu.todolist.dto.LabelResponseDto;
import bo.ucb.edu.todolist.dto.TaskRequestDto;
import bo.ucb.edu.todolist.dto.TaskResponseDto;
import bo.ucb.edu.todolist.entity.Label;
import bo.ucb.edu.todolist.entity.Task;
import bo.ucb.edu.todolist.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskBl {

    private final TaskDao taskDao;
    private final UserDao userDao;
    private final LabelDao labelDao;
    private final Logger logger = LoggerFactory.getLogger(TaskBl.class);
    @Autowired
    private AppConfig appConfig;
    private final ModelMapper modelMapper; // Inyecta el ModelMapper

    @Autowired
    public TaskBl(TaskDao taskDao, UserDao userDao, LabelDao labelDao, ModelMapper modelMapper) {
        this.taskDao = taskDao;
        this.userDao = userDao;
        this.labelDao = labelDao;
        this.modelMapper = modelMapper; // Asigna el ModelMapper
    }
public List<TaskResponseDto> getAllTasks() {
    //usar verificacion de usuario logueado
    Long userId = verifyUserLogged();
    if (userId == null || userId == 0) {
        logger.info("Usuario no válido: " + userId);
        throw new RuntimeException("El usuario no está logueado");
    }
    // Consultar todas las etiquetas del usuario
    List<Label> userLabels = labelDao.findAllLabelsByUserId(userId);
    // Consultar todas las tareas del usuario
    List<Task> tasks = taskDao.findAllTasksByUserId(userId);
    logger.info("Tareas obtenidas obtenidas: " + tasks.toString() + " del usuario: " + userId);
    // Mapear las tareas a TaskResponseDto
    List<TaskResponseDto> taskDtos = tasks.stream()
            .map(task -> {
                TaskResponseDto taskResponseDto = new TaskResponseDto(task);
                // Filtrar las etiquetas que pertenecen al usuario
                List<Label> labelsForTask = userLabels.stream()
                        .filter(label -> label.getLabelId().equals(task.getLabel().getLabelId()))
                        .collect(Collectors.toList());
                // Mapear las etiquetas a LabelResponseDto y asignarlas a la tarea
                List<LabelResponseDto> labelDtos = labelsForTask.stream()
                        .map(LabelResponseDto::new)
                        .collect(Collectors.toList());
                taskResponseDto.getLabel().addAll(labelDtos);
                return taskResponseDto;
            })
            .collect(Collectors.toList());
    logger.info("Tareas obtenidas: " + taskDtos.toString());
    return taskDtos;
}
    public TaskResponseDto getTaskByIdAndUserId(Long taskId) {
        Long userId = verifyUserLogged();
        // Obtener la tarea por taskId y userId
        Task task = taskDao.findById(taskId).orElse(null);
        // Verificar que el usuario esté logueado
        if (userId == null || userId == 0) {
            logger.info("Usuario no válido: " + userId);
            throw new RuntimeException("El usuario no está logueado");
        }



        // Verificar si la tarea existe y pertenece al usuario
        if (task == null || !task.getUser().getUserId().equals(userId)) {
            logger.info("La tarea no existe para este usuario.");
            return null; // Devolver null si la tarea no existe o no pertenece al usuario
        }

        // Mapear la entidad a un TaskResponseDto y devolverlo
        return modelMapper.map(task, TaskResponseDto.class);
    }

    @Transactional
    public TaskResponseDto addTask(TaskRequestDto taskRequestDto) {
        //usar verificacion de usuario logueado
        Long userId = verifyUserLogged();
        if (userId == null || userId == 0) {
            logger.info("Usuario no válido: " + userId);
            throw new RuntimeException("El usuario no está logueado");
        }
        // Obtener el usuario por su ID desde el repositorio de usuarios
        User user = userDao.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        logger.info("Usuario obtenido con id: " + user.getUserId());
        // Crear una nueva tarea y asignarle los valores del DTO
        Task task = new Task();
        task.setTaskName(taskRequestDto.getTaskName());
        task.setDueDate(taskRequestDto.getDueDate());
        task.setStatus(taskRequestDto.getStatus());
        task.setCompletionTime(taskRequestDto.getCompletionTime());
        task.setUser(user);
        //querie para obtener label por labelId

        // Asignar la etiqueta a la tarea si se proporciona el labelId en el DTO
        logger.info("LabelId: " + taskRequestDto.getLabelId());
        //Verificar tarea como esta siendo creada
        logger.info("Tarea antes de ser creada: " + task.toString());
        //asignar usuario a la tarea corregido

        Long labelId = taskRequestDto.getLabelId();
        //Verificar si la etiqueta proporcionada pertenece al usuario
        logger.info("Trea antes de verificar label: " + task.toString());
        if (labelId != null) {
            logger.info("LabelId no es nulo");
            // Obtener la etiqueta por su ID desde el repositorio de etiquetas
            Label label = labelDao.findById(labelId).orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));
            // Asignar la etiqueta a la tarea
            task.setLabel(label);
            logger.info("Etiqueta obtenida: " + label.toString());
            logger.info("usuario" + user.toString());
        }
        logger.info("Tarea creada: " + task.toString());
            // Guardar la tarea en la base de datos
        task = taskDao.save(task);
        logger.info("usuario" + user.toString());
        // Mapear la entidad a un TaskResponseDto y devolverlo
        return modelMapper.map(task, TaskResponseDto.class);
    }
    @Transactional
    public TaskResponseDto editTask(Long taskId, TaskRequestDto taskRequestDto) {
        //usar verificacion de usuario logueado
        Long userId = verifyUserLogged();
        Task task = taskDao.findById(taskId).orElse(null);
        if (task == null || !task.getUser().getUserId().equals(userId)) {
            logger.info("La tarea no existe para este usuario.");
            throw new RuntimeException("La tarea no existe para este usuario.");
        }
        User user = userDao.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        logger.info("Usuario obtenido con id: " + user.getUserId());
        // Actualizar los valores de la tarea con los del DTO
        task.setTaskName(taskRequestDto.getTaskName());
        task.setDueDate(taskRequestDto.getDueDate());
        task.setStatus(taskRequestDto.getStatus());
        task.setCompletionTime(taskRequestDto.getCompletionTime());
        task.setUser(user);
        // Actualizar la etiqueta asociada a la tarea si se proporciona el labelId en el DTO
        Long newLabelId = taskRequestDto.getLabelId();
        if (newLabelId != null) {
            // Verificar si la etiqueta proporcionada pertenece al usuario
            Label label = labelDao.findById(newLabelId).orElse(null);
            if (label != null && label.getUser().getUserId().equals(userId)) {
                // Asignar la nueva etiqueta a la tarea
                task.setLabel(label);
            } else {
                logger.info("La etiqueta no existe o no pertenece al usuario.");
                throw new RuntimeException("La etiqueta no existe o no pertenece al usuario.");
            }
        }
        // Guardar la tarea actualizada en la base de datos
        task = taskDao.save(task);
        // Mapear la entidad actualizada a un TaskResponseDto y devolverlo
        return modelMapper.map(task, TaskResponseDto.class);
    }

    @Transactional
    public void deleteTask(Long taskId) {
        //usar verificacion de usuario logueado
        Long userId = verifyUserLogged();
        Task task = taskDao.findById(taskId).orElse(null);
        if (task == null || !task.getUser().getUserId().equals(userId)) {
            logger.info("La tarea no existe para este usuario.");
            throw new RuntimeException("La tarea no existe para este usuario.");
        }
        taskDao.deleteById(taskId);
    }
    public Long verifyUserLogged(){
        Long userId = appConfig.getUserId();
        if (userId == null || userId == 0) {
            logger.info("Usuario no válido: " + userId);
            throw new RuntimeException("El usuario no está logueado");
        }
        return userId;
    }
}
