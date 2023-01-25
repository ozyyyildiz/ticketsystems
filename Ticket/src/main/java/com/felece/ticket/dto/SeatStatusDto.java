package com.felece.ticket.dto;

public class SeatStatusDto {

    private String Id;

    private String seatStatus;

    public SeatStatusDto() {
    }

    public SeatStatusDto(String id, String seatStatus) {
        Id = id;
        this.seatStatus = seatStatus;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }
}
