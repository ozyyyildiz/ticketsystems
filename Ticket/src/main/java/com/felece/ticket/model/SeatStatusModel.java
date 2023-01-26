package com.felece.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "SeatStatus")
public class SeatStatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatStatus;

    public SeatStatusModel() {
    }

    public SeatStatusModel(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return seatStatus;
    }

    public void setStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }
}
