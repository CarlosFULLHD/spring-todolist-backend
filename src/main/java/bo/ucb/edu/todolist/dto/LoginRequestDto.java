package bo.ucb.edu.todolist.dto;

public class LoginRequestDto {
    //IMPORTANTISIMO, al enviar la api ESTOS CAMPOS seran los que se recibiran
    //POr lo que se deben mandar con estos nombres a la API

    private String user;
    private String password_hash;

    public LoginRequestDto() {

    }

    public LoginRequestDto(String user, String password_hash) {
        this.user = user;
        this.password_hash = password_hash;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    @Override
    public String toString() {
        return "LoginRequestDto{" +
                "user='" + user + '\'' +
                ", password_hash='" + password_hash + '\'' +
                '}';
    }
}
