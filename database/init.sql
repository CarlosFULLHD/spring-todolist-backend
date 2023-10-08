CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password_hash VARCHAR(255) NOT NULL
);
CREATE TABLE labels (
                        label_id SERIAL PRIMARY KEY,
                        label_name VARCHAR(50) NOT NULL,
                        label_color VARCHAR(7), -- Campo opcional para el color del label en formato hexadecimal (#RRGGBB)
                        user_id INT REFERENCES users(user_id) ON DELETE CASCADE
);
CREATE TABLE tasks (
                       task_id SERIAL PRIMARY KEY,
                       task_name VARCHAR(255) NOT NULL,
                       due_date TIMESTAMP NOT NULL,
                       status BOOLEAN NOT NULL DEFAULT FALSE,
                       completion_time TIMESTAMP,
                       user_id INT REFERENCES users(user_id) ON DELETE CASCADE,
                       label_id INT REFERENCES labels(label_id)
)