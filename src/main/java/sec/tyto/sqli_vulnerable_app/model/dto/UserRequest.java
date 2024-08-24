package sec.tyto.sqli_vulnerable_app.model.dto;

public class UserRequest {
    private String username;
    private String bio;
    private String password;

    public UserRequest() {
    }

    public UserRequest(String username, String bio, String password) {
        this.username = username;
        this.bio = bio;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
