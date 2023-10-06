//package bo.ucb.edu.todolist.bl;
//
//import bo.ucb.edu.todolist.dao.TaskDao;
//import bo.ucb.edu.todolist.dao.UserDao;
//import bo.ucb.edu.todolist.dao.LabelDao;
//import bo.ucb.edu.todolist.entity.Task;
//import bo.ucb.edu.todolist.entity.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class TaskBl {
//    private final TaskDao taskDao;
//    private final UserDao userDao;
//    private final LabelDao labelDao;
//    private final Logger logger = LoggerFactory.getLogger(TaskBl.class);
//
//    @Autowired
//    public TaskBl(TaskDao taskDao, UserDao userDao, LabelDao labelDao) {
//        this.taskDao = taskDao;
//        this.userDao = userDao;
//        this.labelDao = labelDao;
//    }
//
//    // Método para obtener todas las tareas
//    public List<Task> getAllTasks() {
//        return taskDao.findAll();
//    }
//
//    // Método para añadir una nueva tarea
//    @Transactional
//    public Task addTask(Task task) {
//        logger.info("Entrando en el método addTask");
//        // Verificar si la tarea tiene una fecha de vencimiento
//        if (task.getDueDate() == null) {
//            throw new RuntimeException("La fecha de vencimiento de la tarea es obligatoria.");
//        }
//        logger.info("Si tiene DueDate");
//        // Verificar si el usuario al que se asignará la tarea existe
//        User user = task.getUser();
//        logger.info("Tarea: {}",  task.getTaskName(),task.getDueDate(),task.getStatus(),task.getCompletionTime(),task.getTaskId());
//        logger.info(String.valueOf(task.getUser()));
//        //AQUI AÑADIR LOGGERS
//        if (user == null || user.getUserId() == null) {
//            throw new RuntimeException("El usuario al que se asignará la tarea no está especificado.");
//        }
//        logger.info("Usuario especificado: {}", user);
//        // Asignar la tarea al usuario
//        user.getTasks().add(task);
//
//        // Puedes guardar el usuario nuevamente si es necesario
//        userDao.save(user);
//
//        // Guardar la nueva tarea en la base de datos
//        Task savedTask = taskDao.save(task);
//        logger.info("Tarea guardada con éxito: {}", savedTask);
//        // Aquí puedes agregar más validaciones y lógica de negocio según tus requerimientos.
//
//        return savedTask;
//    }
//
//
//
//    // Método para editar una tarea
//    @Transactional
//    public Task editTask(Task task) {
//        logger.info("Entrando en el método editTask con taskId: {}", task.getTaskId());
//        // Verificar si la tarea existe
//        Task existingTask = taskDao.findById(task.getTaskId()).orElse(null);
//        if (existingTask == null) {
//            throw new IllegalArgumentException("La tarea no existe.");
//        }
//
//        // Verificar si la tarea tiene una fecha de vencimiento
//        if (task.getDueDate() == null) {
//            throw new RuntimeException("La fecha de vencimiento de la tarea es obligatoria.");
//        }
//
//        // Verificar si el usuario al que se asignará la tarea existe
//        User user = task.getUser();
//        if (user == null || user.getUserId() == null) {
//            throw new RuntimeException("El usuario al que se asignará la tarea no está especificado.");
//        }
//
//        // Asignar la tarea al usuario
//        user.getTasks().add(task);
//
//        // Puedes guardar el usuario nuevamente si es necesario
//        userDao.save(user);
//
//        // Actualizar la tarea en la base de datos
//        Task updatedTask = taskDao.save(task);
//
//        // Aquí puedes agregar más validaciones y lógica de negocio según tus requerimientos.
//
//        return updatedTask;
//    }
//
//    // Método para eliminar una tarea
//    @Transactional
//    public void deleteTask(Long taskId) {
//        logger.info("Entrando en el método deleteTask con taskId: {}", taskId);
//
//        taskDao.deleteById(taskId);
//        logger.info("Tarea eliminada con éxito.");
//    }
//
//    public Task getTaskById(Long taskId) {
//        return taskDao.findById(taskId).orElse(null);
//    }
//}
