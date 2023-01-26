package com.felece.ticket.dto;

public class RouteDto {

    private String Id;

    private String fromCity;

    private String toCity;

    public RouteDto() {
    }

    public RouteDto(String id, String fromCity, String toCity) {
        Id = id;
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
}
