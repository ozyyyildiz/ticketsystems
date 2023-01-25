package com.felece.ticket.request;

public class SeatRequest {

    private String seatNumber;

    public SeatRequest() {
    }

    public SeatRequest(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
