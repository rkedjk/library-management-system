package org.rsreu.library.databaseutil.entities;

public class User {

    private Long id;
    private String type;
    private String login;
    private String password;
    private String status;
    private String name;

    // Getters and Setters for ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters and Setters for TYPE
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getters and Setters for LOGIN
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    // Getters and Setters for PASSWORD
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and Setters for STATUS
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters and Setters for NAME
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
