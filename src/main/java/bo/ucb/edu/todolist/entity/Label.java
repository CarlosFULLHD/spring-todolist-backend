package bo.ucb.edu.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "labels")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_id")
    private Long labelId;

    @NotBlank
    @Column(name = "label_name", nullable = false)
    private String labelName;

    @Column(name = "label_color")
    private String labelColor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Label() {
    }

    public Label(Long labelId, String labelName, String labelColor, User user) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.labelColor = labelColor;
        this.user = user;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(String labelColor) {
        this.labelColor = labelColor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Label{" +
                "labelId=" + labelId +
                ", labelName='" + labelName + '\'' +
                ", labelColor='" + labelColor + '\'' +
                ", user=" + user +
                '}';
    }
}


