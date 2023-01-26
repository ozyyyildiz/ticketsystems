package com.felece.ticket.model;

import javax.persistence.*;

@Entity
@Table(name = "Route")
public class RouteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromCity;

    private String toCity;

    public RouteModel() {
    }

    public RouteModel(String fromCity, String toCity) {
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
