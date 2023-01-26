package com.felece.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "Seat")
public class SeatModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_status_id")
    private SeatStatusModel status;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private VehicleModel vehicle;

    public SeatModel() {
    }

    public SeatModel(String seatNumber, SeatStatusModel status, VehicleModel vehicle) {
        this.seatNumber = seatNumber;
        this.status = status;
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatStatusModel getStatus() {
        return status;
    }

    public void setStatus(SeatStatusModel status) {
        this.status = status;
    }

    public VehicleModel getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleModel vehicle) {
        this.vehicle = vehicle;
    }
}
