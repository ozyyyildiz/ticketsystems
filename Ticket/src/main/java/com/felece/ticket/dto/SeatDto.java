package com.felece.ticket.dto;

public class SeatDto {

    private String Id;

    private String seatNumber;

    private SeatStatusDto status;

    public SeatDto() {
    }

    public SeatDto(String id, String seatNumber, SeatStatusDto status) {
        Id = id;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
