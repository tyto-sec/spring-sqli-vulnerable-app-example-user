package sec.tyto.sqli_vulnerable_app.model;

public class User {
    private Long id;
    private String username;
    private String bio;
    private String password;

    public User() {
    }

    public User(Long id, String username, String bio, String password) {
        this.id = id;
        this.username = username;
        this.bio = bio;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
