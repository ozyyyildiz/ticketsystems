package com.felece.ticket.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "User")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String email;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private UserRoleModel role;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private Set<TicketModel> ticketModels;

    public UserModel() {
    }

    public UserModel(String userName, String email, String password, UserRoleModel role, Set<TicketModel> ticketModels) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.ticketModels = ticketModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserRoleModel getRole() {
        return role;
    }

    public void setRole(UserRoleModel role) {
        this.role = role;
    }

    public Set<TicketModel> getTicketModels() {
        return ticketModels;
    }

    public void setTicketModels(Set<TicketModel> ticketModels) {
        this.ticketModels = ticketModels;
    }
}
