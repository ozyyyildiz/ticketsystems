package com.felece.ticket.dto;

import java.util.List;

public class VehicleDto {

    private String Id;

    private String licensePlate;

    private String expTime;

    private RouteDto routeDto;

    private List<SeatDto> seatDto;

    public VehicleDto() {
    }

    public VehicleDto(String id, String licensePlate, String expTime, RouteDto routeDto, List<SeatDto> seatDto) {
        Id = id;
        this.licensePlate = licensePlate;
        this.expTime = expTime;
        this.routeDto = routeDto;
        this.seatDto = seatDto;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public RouteDto getRouteDto() {
        return routeDto;
    }

    public void setRouteDto(RouteDto routeDto) {
        this.routeDto = routeDto;
    }

    public List<SeatDto> getSeatDto() {
        return seatDto;
    }

    public void setSeatDto(List<SeatDto> seatDto) {
        this.seatDto = seatDto;
    }

    public String getExpTime() {
        return expTime;
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }
}
