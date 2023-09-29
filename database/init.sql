-- Tabla para usuarios
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

-- Tabla para etiquetas
CREATE TABLE labels (
    label_id SERIAL PRIMARY KEY,
    label_name VARCHAR(50) NOT NULL
);

-- Tabla para tareas
CREATE TABLE tasks (
    task_id SERIAL PRIMARY KEY,
    task_name VARCHAR(255) NOT NULL,
    due_date TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL DEFAULT FALSE,
    completion_time TIMESTAMP,
    user_id INT REFERENCES users(user_id) ON DELETE CASCADE
);

-- Tabla intermedia para la relación many-to-many entre tareas y etiquetas
CREATE TABLE task_labels (
    task_id INT REFERENCES tasks(task_id) ON DELETE CASCADE,
    label_id INT REFERENCES labels(label_id) ON DELETE CASCADE,
    PRIMARY KEY (task_id, label_id)
);
