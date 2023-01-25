package com.felece.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "UserRole")
public class UserRoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String roleName;

    public UserRoleModel() {
    }

    public UserRoleModel(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
