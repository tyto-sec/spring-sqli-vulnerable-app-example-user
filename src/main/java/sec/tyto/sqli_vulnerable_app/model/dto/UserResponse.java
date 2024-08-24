package sec.tyto.sqli_vulnerable_app.model.dto;

public class UserResponse {
    private Long id;
    private String username;
    private String bio;

    public UserResponse() {
    }

    public UserResponse(Long id, String username, String bio) {
        this.id = id;
        this.username = username;
        this.bio = bio;
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
}
