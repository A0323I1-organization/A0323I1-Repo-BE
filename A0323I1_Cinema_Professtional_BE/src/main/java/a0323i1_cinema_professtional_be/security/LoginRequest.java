package a0323i1_cinema_professtional_be.security;

public class LoginRequest {
    private String fullname;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String fullname, String password) {
        this.fullname = fullname;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
