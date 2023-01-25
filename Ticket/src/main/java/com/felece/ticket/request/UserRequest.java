package com.felece.ticket.request;

public class UserRequest {

    private String userName;

    private String email;

    private String password;

    private String userRole;

    public UserRequest() {
    }

    public UserRequest(String userName, String email, String password, String userRole) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
