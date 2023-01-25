package com.felece.ticket.response;

import com.felece.ticket.dto.VehicleDto;

import java.util.List;

public class RouteResponse {

    private String id;

    private String fromCity;

    private String toCity;

    private List<VehicleDto> vehicleDtoList;

    public RouteResponse() {
    }

    public RouteResponse(String id, String fromCity, String toCity, List<VehicleDto> vehicleDtoList) {
        this.id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.vehicleDtoList = vehicleDtoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public List<VehicleDto> getVehicleDtoList() {
        return vehicleDtoList;
    }

    public void setVehicleDtoList(List<VehicleDto> vehicleDtoList) {
        this.vehicleDtoList = vehicleDtoList;
    }
}
