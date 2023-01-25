package com.felece.ticket.request;

import com.felece.ticket.dto.RouteDto;
import com.felece.ticket.dto.SeatDto;

import java.util.List;

public class VehicleRequest {

    private String licensePlate;

    private String route;

    private String expTime;

    private int seatCount;

    public VehicleRequest() {
    }

    public VehicleRequest(String licensePlate, String route, String expTime, int seatCount) {
        this.licensePlate = licensePlate;
        this.route = route;
        this.expTime = expTime;
        this.seatCount = seatCount;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getExpTime() {
        return expTime;
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }
}
