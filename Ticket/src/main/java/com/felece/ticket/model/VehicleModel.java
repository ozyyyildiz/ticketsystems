package com.felece.ticket.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Vehicle")
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;

    private Date expTime;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private RouteModel route;

    @OneToMany(mappedBy = "vehicle", cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<SeatModel> seatModels;

    public VehicleModel() {
    }

    public VehicleModel(String licensePlate, Date expTime, RouteModel route, Set<SeatModel> seatModels) {
        this.licensePlate = licensePlate;
        this.expTime = expTime;
        this.route = route;
        this.seatModels = seatModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public RouteModel getRoute() {
        return route;
    }

    public void setRoute(RouteModel route) {
        this.route = route;
    }

    public Set<SeatModel> getSeatModels() {
        return seatModels;
    }

    public void setSeatModels(Set<SeatModel> seatModels) {
        this.seatModels = seatModels;
    }

    public Date getExpTime() {
        return expTime;
    }

    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }
}
