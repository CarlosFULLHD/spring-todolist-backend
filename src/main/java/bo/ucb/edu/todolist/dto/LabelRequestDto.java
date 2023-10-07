package bo.ucb.edu.todolist.dto;

import jakarta.validation.constraints.NotBlank;

public class LabelRequestDto {
    private String labelName;
    private String labelColor;

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

    public LabelRequestDto() {
    }

    public LabelRequestDto(String labelName, String labelColor) {
        this.labelName = labelName;
        this.labelColor = labelColor;
    }

    @Override
    public String toString() {
        return "LabelRequestDto{" +
                "labelName='" + labelName + '\'' +
                ", labelColor='" + labelColor + '\'' +
                '}';
    }
}
