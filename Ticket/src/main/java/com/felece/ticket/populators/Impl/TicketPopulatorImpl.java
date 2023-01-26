package com.felece.ticket.populators.Impl;

import com.felece.ticket.dto.TicketDto;
import com.felece.ticket.dto.TicketStatusDto;
import com.felece.ticket.model.SeatModel;
import com.felece.ticket.model.TicketModel;
import com.felece.ticket.model.TicketStatusModel;
import com.felece.ticket.populators.TicketPopulator;
import com.felece.ticket.populators.UserPopulator;
import com.felece.ticket.request.TicketRequest;
import com.felece.ticket.service.SeatService;
import com.felece.ticket.service.TicketService;
import com.felece.ticket.service.UserService;
import com.felece.ticket.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketPopulatorImpl implements TicketPopulator {

    @Autowired
    private UserPopulator userPopulator;
    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private VehicleService vehicleService;

    @Override
    public TicketDto modelToDto(TicketModel ticketModel) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(String.valueOf(ticketModel.getId()));
        ticketDto.setUser(userPopulator.modelToDto(ticketModel.getUser()).getId());
        ticketDto.setName(ticketModel.getName());
        ticketDto.setSurname(ticketModel.getSurname());
        ticketDto.setTicketStatus(ticketService.getTicketStatus(ticketModel.getTicketStatus().getId()).getTicketStatus());
        if(ticketModel.getSeatNumber() != null && ticketModel.getVehicle() != null){
            SeatModel seatModel = seatService.getSeatModel(ticketModel.getSeatNumber().getId());
            ticketDto.setSeatId(seatModel.getSeatNumber());
            ticketDto.setVehicle(vehicleService.getVehicleModel(ticketModel.getVehicle().getId()).getLicensePlate());
        }
        return ticketDto;
    }

    @Override
    public TicketModel dtoToModel(TicketDto ticketDto) {
        TicketModel ticketModel = new TicketModel();
        ticketModel.setId(Long.parseLong(ticketDto.getId()));
        ticketModel.setName(ticketDto.getName());
        ticketModel.setSurname(ticketDto.getSurname());
        ticketModel.setUser(userService.getUserModel(Long.parseLong(ticketDto.getUser())));
        ticketModel.setTicketStatus(ticketService.getTicketStatusByName(ticketDto.getTicketStatus()));
        if(ticketDto.getSeatId() != null && ticketDto.getVehicle() != null){
            ticketModel.setSeatNumber(seatService.getSeatModel(Long.parseLong(ticketDto.getSeatId())));
            ticketModel.setVehicle(vehicleService.getVehicleModelByPlate(ticketDto.getVehicle()));
        }
        return ticketModel;
    }

    @Override
    public TicketModel dtoToModelForSave(TicketRequest ticketRequest) {
        TicketModel ticketModel = new TicketModel();
        ticketModel.setName(ticketRequest.getName());
        ticketModel.setSurname(ticketRequest.getSurname());
        ticketModel.setUser(userService.getByUsername(ticketRequest.getUser()));
        ticketModel.setTicketStatus(ticketService.getTicketStatusByName(ticketRequest.getTicketStatus()));
        ticketModel.setSeatNumber(seatService.getSeatModel(Long.parseLong(ticketRequest.getSeat())));
        ticketModel.setVehicle(vehicleService.getVehicleModel(Long.parseLong(ticketRequest.getVehicle())));
        return ticketModel;
    }
}
