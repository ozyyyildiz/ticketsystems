package com.felece.ticket.facade.impl;

import com.felece.ticket.facade.SeatFacade;
import com.felece.ticket.response.SeatResponse;
import com.felece.ticket.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeatFacadeImpl implements SeatFacade {

    @Autowired
    private SeatService seatService;

    @Override
    public List<SeatResponse> getAllEmptySeats() {
        List<SeatResponse> seatResponseList = new ArrayList<>();
        seatService.getAllEmptySeats().forEach(seatModel -> {
            SeatResponse seatResponse = new SeatResponse();
            seatResponse.setId(String.valueOf(seatModel.getId()));
            seatResponse.setSeatNumber(String.valueOf(seatModel.getSeatNumber()));
            seatResponse.setStatus(seatModel.getStatus().getStatus());
            if(seatModel.getVehicle().getRoute()!=null){
                String route = seatModel.getVehicle().getRoute().getToCity() + " - " + seatModel.getVehicle().getRoute().getFromCity();
                seatResponse.setRoute(route);
            }
            seatResponse.setVehicle(seatModel.getVehicle().getLicensePlate());
            seatResponseList.add(seatResponse);
        });
        return seatResponseList;
    }
}
