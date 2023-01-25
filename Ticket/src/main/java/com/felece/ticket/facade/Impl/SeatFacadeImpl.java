package com.felece.ticket.facade.Impl;

import com.felece.ticket.dto.SeatDto;
import com.felece.ticket.facade.SeatFacade;
import com.felece.ticket.model.SeatModel;
import com.felece.ticket.populators.SeatPopulator;
import com.felece.ticket.request.SeatRequest;
import com.felece.ticket.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeatFacadeImpl implements SeatFacade {

    @Autowired
    private SeatService seatService;

    @Autowired
    private SeatPopulator seatPopulator;

    @Override
    public SeatDto getSeat(String id) {
        SeatModel seatModel = seatService.getSeatModel(Long.parseLong(id));
        SeatDto seatDto = seatPopulator.modelToDto(seatModel);
        return seatDto;
    }

    @Override
    public List<SeatDto> getAllSeats() {
        List<SeatDto> seatDtoList = new ArrayList<>();
        seatService.getAllSeats().stream().forEach(seatModel -> {
            seatDtoList.add(seatPopulator.modelToDto(seatModel));
        });
        return seatDtoList;
    }

    @Override
    public List<SeatDto> getAllSeatsOfVehicle(String id) {
        List<SeatDto> seatDtoList = new ArrayList<>();
        seatService.getAllVehicleSeats(Long.parseLong(id)).stream().forEach(seatModel -> {
            seatDtoList.add(seatPopulator.modelToDto(seatModel));
        });
        return seatDtoList;
    }

    @Override
    public Boolean saveSeat(SeatRequest seatRequest) {
        return null;
    }

    @Override
    public Boolean updateSeat(SeatDto seatDto) {
        return null;
    }
}
