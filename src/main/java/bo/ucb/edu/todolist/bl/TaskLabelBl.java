package bo.ucb.edu.todolist.bl;

import bo.ucb.edu.todolist.dao.TaskLabelDao;
import bo.ucb.edu.todolist.dao.TaskDao;
import bo.ucb.edu.todolist.dao.LabelDao;
import bo.ucb.edu.todolist.dto.TaskLabelRequestDto;
import bo.ucb.edu.todolist.entity.Task;
import bo.ucb.edu.todolist.entity.Label;
import bo.ucb.edu.todolist.entity.TaskLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskLabelBl {
    private final TaskLabelDao taskLabelDao;
    private final TaskDao taskDao;
    private final LabelDao labelDao;
    private final Logger logger = LoggerFactory.getLogger(TaskLabelBl.class);

    @Autowired
    public TaskLabelBl(TaskLabelDao taskLabelDao, TaskDao taskDao, LabelDao labelDao) {
        this.taskLabelDao = taskLabelDao;
        this.taskDao = taskDao;
        this.labelDao = labelDao;
    }

    @Transactional
    public void assignLabelToTask(TaskLabelRequestDto requestDto) {
        Long taskId = requestDto.getTask();
        Long labelId = requestDto.getLabel();

        Task task = taskDao.findById(taskId).orElse(null);
        Label label = labelDao.findById(labelId).orElse(null);

        if (task == null || label == null) {
            throw new RuntimeException("Tarea o etiqueta no encontrada.");
        }

        TaskLabel taskLabel = new TaskLabel(null,task, label);
        taskLabelDao.save(taskLabel);
    }

    @Transactional
    public void removeLabelFromTask(TaskLabelRequestDto requestDto) {
        Long taskId = requestDto.getTask();
        Long labelId = requestDto.getLabel();

        Task task = taskDao.findById(taskId).orElse(null);
        Label label = labelDao.findById(labelId).orElse(null);

        if (task == null || label == null) {
            throw new RuntimeException("Tarea o etiqueta no encontrada.");
        }

        TaskLabel taskLabel = taskLabelDao.findByTaskAndLabel(task, label);
        if (taskLabel != null) {
            taskLabelDao.delete(taskLabel);
        }
    }

    public List<TaskLabel> getAllTaskLabels() {
        return taskLabelDao.findAll();
    }

    @Transactional
    public TaskLabel addTaskLabel(TaskLabel taskLabel) {
        // Puedes agregar validaciones adicionales si es necesario antes de guardar la relación
        return taskLabelDao.save(taskLabel);
    }

    @Transactional
    public TaskLabel editTaskLabel(Long taskLabelId, TaskLabel updatedTaskLabel) {
        // Buscar la relación entre tarea y etiqueta por ID
        TaskLabel existingTaskLabel = taskLabelDao.findById(taskLabelId).orElse(null);
        if (existingTaskLabel == null) {
            throw new RuntimeException("La relación entre tarea y etiqueta no existe.");
        }

        // Actualizar los campos de la relación entre tarea y etiqueta según los datos proporcionados en updatedTaskLabel
        existingTaskLabel.setTask(updatedTaskLabel.getTask());
        existingTaskLabel.setLabel(updatedTaskLabel.getLabel());

        // Guardar la relación actualizada en la base de datos
        return taskLabelDao.save(existingTaskLabel);
    }

    @Transactional
    public void deleteTaskLabel(Long taskLabelId) {
        // Buscar la relación entre tarea y etiqueta por ID
        TaskLabel existingTaskLabel = taskLabelDao.findById(taskLabelId).orElse(null);
        if (existingTaskLabel == null) {
            throw new RuntimeException("La relación entre tarea y etiqueta no existe.");
        }

        // Eliminar la relación de la base de datos
        taskLabelDao.delete(existingTaskLabel);
    }
}
