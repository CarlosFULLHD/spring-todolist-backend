
-- Insertar datos de ejemplo en la tabla users
INSERT INTO users (username, password_hash)
VALUES
    ('usuario1', 'password123'),
    ('usuario2', 'password2'),
    ('usuario3', 'password3');

-- Labels para el Usuario 1 (user_id = 1)
INSERT INTO labels (label_name, user_id, label_color) VALUES
                                                          ('Trabajo', 1, '#FF5733'),
                                                          ('Personal', 1, '#0077FF'),
                                                          ('Importante', 1, '#FFA500');

-- Labels para el Usuario 2 (user_id = 2)
INSERT INTO labels (label_name, user_id, label_color) VALUES
                                                          ('Proyecto', 2, '#009900'),
                                                          ('Urgente', 2, '#FF0000');

-- Labels para el Usuario 3 (user_id = 3)
INSERT INTO labels (label_name, user_id, label_color) VALUES
                                                          ('Estudio', 3, '#6600CC'),
                                                          ('Casa', 3, '#996633');


-- Tareas para el Usuario 1 (user_id = 1)
INSERT INTO tasks (task_name, due_date, status, user_id) VALUES
                                                             ('Terminar informe', '2023-10-10 15:00:00', FALSE, 1),
                                                             ('Reunión con el equipo', '2023-10-15 10:30:00', FALSE, 1);

-- Tareas para el Usuario 2 (user_id = 2)
INSERT INTO tasks (task_name, due_date, status, user_id) VALUES
                                                             ('Preparar presentación', '2023-10-12 14:00:00', FALSE, 2),
                                                             ('Enviar informe semanal', '2023-10-20 09:00:00', FALSE, 2);

-- Tareas para el Usuario 3 (user_id = 3)
INSERT INTO tasks (task_name, due_date, status, user_id) VALUES
                                                             ('Estudiar para el examen', '2023-10-11 18:00:00', FALSE, 3),
                                                             ('Comprar víveres', '2023-10-14 17:30:00', FALSE, 3);


-- Insertar relaciones
-- Asociar labels a tareas para el Usuario 1 (user_id = 1)
-- Tarea 1 (task_id = 1) se asocia con los labels 'Trabajo' y 'Importante'
INSERT INTO task_labels (task_id, label_id) VALUES
                                                (1, 1), -- Tarea 1 relacionada con 'Trabajo'
                                                (1, 3); -- Tarea 1 relacionada con 'Importante'

-- Tarea 2 (task_id = 2) se asocia con el label 'Personal'
INSERT INTO task_labels (task_id, label_id) VALUES
    (2, 2); -- Tarea 2 relacionada con 'Personal'

-- USUARIO 2: Asociar labels a tareas para el Usuario 2 (user_id = 2)
-- Tarea 3 (task_id = 3) se asocia con el label 'Proyecto'
INSERT INTO task_labels (task_id, label_id) VALUES
    (3, 4); -- Tarea 3 relacionada con 'Proyecto'

-- Tarea 4 (task_id = 4) se asocia con el label 'Urgente'
INSERT INTO task_labels (task_id, label_id) VALUES
    (4, 5); -- Tarea 4 relacionada con 'Urgente'

-- USUARIO 3: Asociar labels a tareas para el Usuario 3 (user_id = 3)
-- Tarea 5 (task_id = 5) se asocia con el label 'Estudio'
INSERT INTO task_labels (task_id, label_id) VALUES
    (5, 6); -- Tarea 5 relacionada con 'Estudio'

-- Tarea 6 (task_id = 6) se asocia con el label 'Casa'
INSERT INTO task_labels (task_id, label_id) VALUES
    (6, 7); -- Tarea 6 relacionada con 'Casa'




-- VERIFICAR DATOS INSERTADOS
select * from users;
select * from tasks;
select * from labels;
select * from task_labels;

-- INSERTAR DATOS DE USUARIO NUEVO
INSERT INTO users (username, password_hash)
VALUES
    ('usuarionuevo', '1234');


-- DROP TABLES
drop table task_labels;
drop table tasks;
drop table users;
drop table labels;