package Logica;

public class User {
    private int code;
    private String username;
    private String password;

    public User(int code, String username, String password) {
        setCode(code);
        setPassword(password);
        setUsername(username);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
