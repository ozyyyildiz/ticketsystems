package com.felece.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "TicketStatus")
public class TicketStatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketStatus;

    public TicketStatusModel() {
    }

    public TicketStatusModel(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
