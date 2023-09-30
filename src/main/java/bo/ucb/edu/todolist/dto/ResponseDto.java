package bo.ucb.edu.todolist.dto;

import bo.ucb.edu.todolist.entity.Task;

public class ResponseDto {
    private String code;
    private Object result;
    private String message;

    //Solo usamos 2 constructores para que el programador ya no haga lo que le de la gana

    //Constructor para cuando se obtenga una respuesta correcta

    public ResponseDto(Object result) {
        this.code = "Task-0000";
        this.result=result;
    }

    //Constructor para cuando se tenga un error,
    //Agregar codigo de error y un mensaje
    //Esto anterior debe ser unico por error con un excel de posibles errores
    public ResponseDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseDto(String code, Task updatedTask) {
        this.code = code;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "code='" + code + '\'' +
                ", result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
