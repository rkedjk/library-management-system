package org.rsreu.library.databaseutil.entities;


public class Account {
    private int id;
    private String type;
    private String login;
    private String password;
    private String status;

    private String name;
    public Account(int id, String type, String login, String password, String status,String name) {
        this.id = id;
        this.type = type;
        this.login = login;
        this.password = password;
        this.status = status;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
