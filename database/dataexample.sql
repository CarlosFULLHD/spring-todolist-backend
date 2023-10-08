INSERT INTO users (username, password_hash) VALUES
                                                ('usuario1', 'password123'),
                                                ('usuario2', 'password1234'),
                                                ('usuario3', 'password12345');

-- Etiquetas ejemplo
INSERT INTO labels (label_name, label_color, user_id) VALUES
                                                          ('Trabajo', '#FF5733', 1),
                                                          ('Personal', '#3498DB', 1),
                                                          ('Importante', '#E74C3C', 1),
                                                          ('Trabajo', '#FF5733', 2),
                                                          ('Deportes', '#27AE60', 2),
                                                          ('Compras', '#F1C40F', 2),
                                                          ('Personal', '#3498DB', 3),
                                                          ('Viajes', '#9B59B6', 3),
                                                          ('Proyectos', '#E67E22', 3);

-- Tareas para el usuario 1
INSERT INTO tasks (task_name, due_date, status, user_id, label_id) VALUES
                                                                       ('Tarea 1', '2023-10-15', FALSE, 1, 1),
                                                                       ('Tarea 2', '2023-10-20', FALSE, 1, 2),
                                                                       ('Tarea 3', '2023-10-25', TRUE, 1, 3),
                                                                       ('Tarea 1', '2023-10-15', TRUE, 2, 4),
                                                                       ('Tarea 2', '2023-10-20', FALSE, 2, 5),
                                                                       ('Tarea 3', '2023-10-25', FALSE, 2, 6),
                                                                       ('Tarea 1', '2023-10-15', FALSE, 3, 7),
                                                                       ('Tarea 2', '2023-10-20', FALSE, 3, 8),
                                                                       ('Tarea 3', '2023-10-25', TRUE, 3, 9);


