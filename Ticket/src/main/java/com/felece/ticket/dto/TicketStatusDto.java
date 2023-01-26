package com.felece.ticket.dto;

public class TicketStatusDto {

    private String id;

    private String ticketStatus;

    public TicketStatusDto() {
    }

    public TicketStatusDto(String id, String ticketStatus) {
        this.id = id;
        this.ticketStatus = ticketStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
