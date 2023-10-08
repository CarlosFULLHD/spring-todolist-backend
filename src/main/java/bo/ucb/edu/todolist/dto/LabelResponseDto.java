package bo.ucb.edu.todolist.dto;

import bo.ucb.edu.todolist.entity.Label;

import java.util.List;

public class LabelResponseDto {
    private Long labelId;
    private String labelName;
    private String labelColor;

    public LabelResponseDto(Long labelId, String labelName, String labelColor) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.labelColor = labelColor;
    }

    public LabelResponseDto() {
    }

    public LabelResponseDto(Label label) {
        this.labelId = label.getLabelId();
        this.labelName = label.getLabelName();
        this.labelColor = label.getLabelColor();
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

    public void addAll(List<LabelResponseDto> labelDtos) {
    }
}
