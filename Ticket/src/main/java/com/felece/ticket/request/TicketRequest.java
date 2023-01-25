package com.felece.ticket.request;

public class TicketRequest {

    private String name;

    private String surname;

    private String user;

    private String vehicle;

    private String seatId;

    private String ticketStatus;

    public TicketRequest() {
    }

    public TicketRequest(String name, String surname, String user, String vehicle, String seatId, String ticketStatus) {
        this.name = name;
        this.surname = surname;
        this.user = user;
        this.vehicle = vehicle;
        this.seatId = seatId;
        this.ticketStatus = ticketStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}

