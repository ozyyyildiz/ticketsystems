package com.felece.ticket.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SeatStatus")
public class SeatStatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String seatStatus;

    public SeatStatusModel() {
    }

    public SeatStatusModel(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStatus() {
        return seatStatus;
    }

    public void setStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }
}
