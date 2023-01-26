package com.felece.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
public class TicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private VehicleModel vehicle;

    @OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_id")
    private SeatModel seatNumber;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_status_id")
    private TicketStatusModel ticketStatus;

    public TicketModel() {
    }

    public TicketModel(String name, String surname, UserModel user, VehicleModel vehicle, SeatModel seatNumber, TicketStatusModel ticketStatus) {
        this.name = name;
        this.surname = surname;
        this.user = user;
        this.vehicle = vehicle;
        this.seatNumber = seatNumber;
        this.ticketStatus = ticketStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public VehicleModel getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleModel vehicle) {
        this.vehicle = vehicle;
    }

    public SeatModel getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(SeatModel seatNumber) {
        this.seatNumber = seatNumber;
    }

    public TicketStatusModel getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatusModel ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
