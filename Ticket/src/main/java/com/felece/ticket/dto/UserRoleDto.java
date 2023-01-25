package com.felece.ticket.dto;

public class UserRoleDto {

    private String Id;

    private String roleName;

    public UserRoleDto() {
    }

    public UserRoleDto(String id, String roleName) {
        Id = id;
        this.roleName = roleName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
