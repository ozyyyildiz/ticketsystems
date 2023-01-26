package com.felece.ticket.dto;

public class SeatDto {

    private String id;

    private String seatNumber;

    private SeatStatusDto status;

    public SeatDto() {
    }

    public SeatDto(String id, String seatNumber, SeatStatusDto status) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatStatusDto getStatus() {
        return status;
    }

    public void setStatus(SeatStatusDto status) {
        this.status = status;
    }
}
