-- Insertar tres usuarios
INSERT INTO users (username, password_hash)
VALUES
    ('Bruno', 'passwordhash1'),
    ('Benjamin', 'passwordhash2'),
    ('Ryan', 'passwordhash3');
-- Insertar tres etiquetas (una para cada usuario)
INSERT INTO labels (label_name, user_id)
VALUES
    ('Personal', 1), -- Asignar etiqueta 'Personal' al usuario 1
    ('Work', 2),    -- Asignar etiqueta 'Work' al usuario 2
    ('Study', 3);   -- Asignar etiqueta 'Study' al usuario 3
-- Insertar tres tareas para el usuario 1, asignando etiquetas diferentes
INSERT INTO tasks (task_name, due_date, status, user_id, label_id)
VALUES
    ('Call to Brenda', NOW() + INTERVAL '3 days', FALSE, 1, 1), -- Etiqueta 'Personal'
    ('Work in the backend', NOW() + INTERVAL '5 days', FALSE, 1, 2), -- Etiqueta 'Work'
    ('Read the ego is the enemy by Ryan Holiday', NOW() + INTERVAL '7 days', FALSE, 1, 3); -- Etiqueta 'Study'
-- Insertar tres tareas para el usuario 2, asignando etiquetas diferentes
INSERT INTO tasks (task_name, due_date, status, user_id, label_id)
VALUES
    ('COmplete the information task', NOW() + INTERVAL '2 days', FALSE, 2, 2), -- Etiqueta 'Work'
    ('Watch the TV serie the playlist', NOW() + INTERVAL '4 days', FALSE, 2, 3), -- Etiqueta 'Study'
    ('Prepare pate with Ryan on Friday', NOW() + INTERVAL '6 days', FALSE, 2, 1); -- Etiqueta 'Personal'

-- Insertar tres tareas para el usuario 3, asignando etiquetas diferentes
INSERT INTO tasks (task_name, due_date, status, user_id, label_id)
VALUES
    ('Take the course learn how to learn', NOW() + INTERVAL '1 day', FALSE, 3, 3), -- Etiqueta 'Study'
    ('Watch the movie The Pursuit of Happyness with my dog', NOW() + INTERVAL '3 days', FALSE, 3, 1), -- Etiqueta 'Personal'
    ('Send the report to my boss', NOW() + INTERVAL '5 days', FALSE, 3, 2); -- Etiqueta 'Work'

-- Insertar una tarea completada para cada usuario con datos al azar
INSERT INTO completed_tasks (task_id, completion_time)
VALUES
    (1, NOW() - INTERVAL '1 day' + INTERVAL '3 hours'), -- Completar Task 1 de User 1
    (5, NOW() - INTERVAL '2 days' + INTERVAL '4 hours'), -- Completar Task 1 de User 2
    (9, NOW() - INTERVAL '3 days' + INTERVAL '2 hours'); -- Completar Task 1 de User 3


-- Obtener las tablas de los datos de ejemplo insertados
SELECT * FROM users;
SELECT * FROM labels;
SELECT * FROM tasks;
SELECT * FROM completed_tasks;
