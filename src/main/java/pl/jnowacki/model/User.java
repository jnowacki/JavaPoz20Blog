package pl.jnowacki.model;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;
    private String username;
    private String password;
    private Boolean active;
    private String token;

    public User() {
    }

    public User(Long id, String username, String password, Boolean active, String token) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.token = token;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
