package com.felece.ticket.dto;

import java.util.List;

public class TicketStatusDto {

    private String Id;

    private String ticketStatus;

    public TicketStatusDto() {
    }

    public TicketStatusDto(String id, String ticketStatus) {
        Id = id;
        this.ticketStatus = ticketStatus;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
