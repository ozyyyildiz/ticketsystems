package com.felece.ticket.response;

public class SeatResponse {

    private String id;

    private String seatNumber;

    private String vehicle;

    private String route;

    private String status;

    public SeatResponse() {
    }

    public SeatResponse(String id, String seatNumber, String vehicle, String route, String status) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.vehicle = vehicle;
        this.route = route;
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

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
