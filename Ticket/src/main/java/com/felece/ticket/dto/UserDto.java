package com.felece.ticket.dto;

public class UserDto {

    private String Id;

    private String userName;

    private String email;

    private String password;

    private String userRole;

    public UserDto() {
    }

    public UserDto(String id, String userName, String email, String password, String userRole) {
        Id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public UserDto(String id, String userName, String email, String userRole) {
        Id = id;
        this.userName = userName;
        this.email = email;
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
