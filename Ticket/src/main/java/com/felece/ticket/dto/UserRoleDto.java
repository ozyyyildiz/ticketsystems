package com.felece.ticket.dto;

public class UserRoleDto {

    private String id;

    private String roleName;

    public UserRoleDto() {
    }

    public UserRoleDto(String id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
