package bo.ucb.edu.todolist.dto;

public class LabelRequestDto {
    private String labelName;

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public LabelRequestDto() {
    }

    public LabelRequestDto(String labelName) {
        this.labelName = labelName;
    }

    @Override
    public String toString() {
        return "LabelRequestDto{" +
                "labelName='" + labelName + '\'' +
                '}';
    }
}
