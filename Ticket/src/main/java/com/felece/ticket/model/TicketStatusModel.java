package com.felece.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "TicketStatus")
public class TicketStatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String ticketStatus;

    public TicketStatusModel() {
    }

    public TicketStatusModel(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
