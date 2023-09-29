-- Insertar datos de ejemplo en la tabla 'users'
INSERT INTO users (username, password_hash)
VALUES
    ('usuario1', 'password123'),
    ('usuario2', 'secret456');

-- Insertar datos de ejemplo en la tabla 'labels'
INSERT INTO labels (label_name)
VALUES
    ('Personal'),
    ('Trabajo'),
    ('Estudio');

-- Insertar datos de ejemplo en la tabla 'tasks' (asociadas a usuarios)
INSERT INTO tasks (task_name, due_date, status, user_id)
VALUES
    ('Tarea 1', '2023-10-01', true, 1),
    ('Tarea 2', '2023-10-02', false, 1),
    ('Tarea 3', '2023-10-03', false, 2);

-- Insertar datos de ejemplo en la tabla 'task_labels' (asociación de tareas a etiquetas)
INSERT INTO task_labels (task_id, label_id)
VALUES
    (1, 1), -- Tarea 1 pertenece a la etiqueta Personal
    (2, 2), -- Tarea 2 pertenece a la etiqueta Trabajo
    (3, 1), -- Tarea 3 pertenece a la etiqueta Personal
    (3, 3); -- Tarea 3 pertenece a la etiqueta Estudio
