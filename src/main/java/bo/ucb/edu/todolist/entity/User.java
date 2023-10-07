package bo.ucb.edu.todolist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank
    @Size(max = 255)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(max = 255)
    @Column(name = "password_hash")
    private String passwordHash;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore // Ignorar la relación en esta dirección
    private Set<Task> tasks = new HashSet<>();

    //Relacion one to many con label
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore // Ignorar la relación en esta dirección
    private Set<Label> labels = new HashSet<>();

    public User(Long userId) {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public User() {
    }

    public User(Long userId, String username, String passwordHash, Set<Task> tasks, Set<Label> labels) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.tasks = tasks;
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", taskCount=" + tasks.size() + // Puedes mostrar la cantidad de tareas en lugar de las tareas mismas
                ", labelCount=" + labels.size() + // Puedes mostrar la cantidad de etiquetas en lugar de las etiquetas mismas
                '}';
    }

}
