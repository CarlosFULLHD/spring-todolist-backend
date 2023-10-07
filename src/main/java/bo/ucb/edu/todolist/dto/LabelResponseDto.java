package bo.ucb.edu.todolist.dto;

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
}
