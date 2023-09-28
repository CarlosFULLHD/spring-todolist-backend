-- Tabla para usuarios
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

-- Tabla para etiquetas
CREATE TABLE labels (
    label_id SERIAL PRIMARY KEY,
    label_name VARCHAR(50) NOT NULL,
    user_id INT REFERENCES users(user_id) ON DELETE CASCADE
);

-- Tabla para tareas
CREATE TABLE tasks (
    task_id SERIAL PRIMARY KEY,
    task_name VARCHAR(255) NOT NULL,
    due_date TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL DEFAULT FALSE,
    user_id INT REFERENCES users(user_id) ON DELETE CASCADE,
    label_id INT REFERENCES labels(label_id) ON DELETE SET NULL
);

-- Tabla para tareas completadas
CREATE TABLE completed_tasks (
    completed_task_id SERIAL PRIMARY KEY,
    task_id INT REFERENCES tasks(task_id) ON DELETE CASCADE,
    completion_time TIMESTAMP NOT NULL
);
