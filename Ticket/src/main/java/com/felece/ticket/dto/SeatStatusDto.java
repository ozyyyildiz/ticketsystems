package com.felece.ticket.dto;

public class SeatStatusDto {

    private String id;

    private String seatStatus;

    public SeatStatusDto() {
    }

    public SeatStatusDto(String id, String seatStatus) {
        this.id = id;
        this.seatStatus = seatStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }
}
