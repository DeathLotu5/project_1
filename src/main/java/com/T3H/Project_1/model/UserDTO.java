package com.T3H.Project_1.model;

public class UserDTO {

    private int id;

    private String email;

    private String name;

    private String password;

    private String roles;

    private String username;

    public UserDTO() {

    }

    public UserDTO(int id, String email, String name, String password, String roles, String username) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.username = username;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return this.roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
