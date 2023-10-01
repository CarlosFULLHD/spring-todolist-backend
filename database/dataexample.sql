-- Insertar datos de ejemplo en la tabla users
INSERT INTO users (username, password_hash)
VALUES
    ('usuario1', 'password123'),
    ('usuario2', 'password2'),
    ('usuario3', 'password3');

-- Insertar datos de ejemplo en la tabla labels
INSERT INTO labels (label_name)
VALUES
    ('Personal'),
    ('Trabajo'),
    ('Estudio');

-- Insertar datos de ejemplo en la tabla tasks y sus relaciones en task_labels
INSERT INTO tasks (task_name, due_date, status, user_id)
VALUES
    ('Tarea1 de Usuario1', NOW(), FALSE, 1),
    ('Tarea2 de Usuario1', NOW(), FALSE, 1),
    ('Tarea3 de Usuario1', NOW(), FALSE, 1),
    ('Tarea1 de Usuario2', NOW(), FALSE, 2),
    ('Tarea2 de Usuario2', NOW(), FALSE, 2),
    ('Tarea3 de Usuario2', NOW(), FALSE, 2),
    ('Tarea1 de Usuario3', NOW(), FALSE, 3),
    ('Tarea2 de Usuario3', NOW(), FALSE, 3),
    ('Tarea3 de Usuario3', NOW(), FALSE, 3);

-- Insertar relaciones many-to-many en la tabla task_labels
INSERT INTO task_labels (task_id, label_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 1),
    (5, 2),
    (6, 3),
    (7, 1),
    (8, 2),
    (9, 3);


   -- SELECT FROM
   select * from users;
   select * from tasks;
   select * from labels;
   select * from task_labels;

   INSERT INTO users (username, password_hash)
   VALUES
       ('usuarionuevo', '1234');