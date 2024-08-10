package Logica;

public class User {
    private int code;
    private String username;
    private String password;
    private int role;

    public User(int code, String username, String password,int role) {
        setCode(code);
        setPassword(password);
        setUsername(username);
        setRole(role);
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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
