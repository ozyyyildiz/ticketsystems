package com.felece.ticket.populators.Impl;

import com.felece.ticket.dto.SeatDto;
import com.felece.ticket.dto.SeatStatusDto;
import com.felece.ticket.model.SeatModel;
import com.felece.ticket.model.SeatStatusModel;
import com.felece.ticket.populators.SeatPopulator;
import com.felece.ticket.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;

public class SeatPopulatorImpl implements SeatPopulator {

    @Autowired
    private SeatService seatService;

    @Override
    public SeatDto modelToDto(SeatModel seatModel) {
        SeatDto seatDto = new SeatDto();
        seatDto.setId(String.valueOf(seatModel.getId()));
        seatDto.setSeatNumber(seatModel.getSeatNumber());
        seatDto.setStatus(seatStatusModelToDto(seatModel.getStatus()));
        return seatDto;
    }

    @Override
    public SeatModel dtoToModel(SeatDto seatDto) {
        SeatModel seatModel = new SeatModel();
        seatModel.setId(Long.parseLong(seatDto.getId()));
        seatModel.setSeatNumber(seatDto.getSeatNumber());
        seatModel.setStatus(seatService.getSeatStatus(Long.parseLong(seatDto.getStatus().getId())));
        return seatModel;
    }

    private SeatStatusDto seatStatusModelToDto(SeatStatusModel seatStatusModel){
        SeatStatusDto seatStatusDto = new SeatStatusDto();
        seatStatusDto.setId(String.valueOf(seatStatusModel.getId()));
        seatStatusDto.setSeatStatus(seatStatusModel.getStatus());
        return seatStatusDto;
    }
}
