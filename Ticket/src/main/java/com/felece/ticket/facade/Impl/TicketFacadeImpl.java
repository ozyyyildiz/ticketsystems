package com.felece.ticket.facade.impl;

import com.felece.ticket.dto.TicketDto;
import com.felece.ticket.facade.TicketFacade;
import com.felece.ticket.model.SeatModel;
import com.felece.ticket.model.TicketModel;
import com.felece.ticket.populators.TicketPopulator;
import com.felece.ticket.request.TicketRequest;
import com.felece.ticket.response.ResponseMessage;
import com.felece.ticket.service.SeatService;
import com.felece.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketFacadeImpl implements TicketFacade {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private TicketPopulator ticketPopulator;

    @Override
    public TicketDto getTicket(String id) {
        return ticketPopulator.modelToDto(ticketService.getTicketModel(Long.parseLong(id)));
    }

    @Override
    public List<TicketDto> getTicketByUsername(String username) {
        List<TicketDto> ticketDtoList = new ArrayList<>();
        ticketService.getTicketModelsByUsername(username).stream().forEach(ticketModel -> {
            TicketDto ticketDto = ticketPopulator.modelToDto(ticketModel);
            ticketDtoList.add(ticketDto);
        });
        return ticketDtoList;
    }

    @Override
    public List<TicketDto> getAllTickets() {
        List<TicketDto> ticketDtoList = new ArrayList<>();
        ticketService.getAllTicketModel().stream().forEach(ticketModel -> {
            TicketDto ticketDto = ticketPopulator.modelToDto(ticketModel);
            ticketDtoList.add(ticketDto);
        });
        return ticketDtoList;
    }

    @Override
    public ResponseMessage saveTicket(TicketRequest ticketRequest) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Bilet oluşturulurken bir hata meydana geldi.");
        TicketModel ticketModel = ticketPopulator.dtoToModelForSave(ticketRequest);
        if (ticketService.saveTicketModel(ticketModel)) {
            SeatModel seatModel = seatService.getSeatModel(Long.parseLong(ticketRequest.getSeat()));
            if(ticketRequest.getTicketStatus().equals("RESERVED")){
                seatModel.setStatus(seatService.getSeatStatusByName(ticketRequest.getTicketStatus()));
                seatService.saveSeat(seatModel);
            }else if(ticketRequest.getTicketStatus().equals("PURCHASED")){
                seatModel.setStatus(seatService.getSeatStatusByName("OCCUPIED"));
                seatService.saveSeat(seatModel);
            }else{
                responseMessage.setStatus(false);
                responseMessage.setMessage("Koltuk rezerve edilirken bir hata oluştu.");
                return responseMessage;
            }
            responseMessage.setStatus(true);
            responseMessage.setMessage("Bilet başarıyla oluşturuldu.");
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage updateTicket(TicketDto ticketDto) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Bilet güncellenirken bir hata oluştu.");
        SeatModel seatModel = ticketService.getTicketModel(Long.parseLong(ticketDto.getId())).getSeatNumber();
        TicketModel ticketModel = ticketPopulator.dtoToModel(ticketDto);
        ticketModel.setSeatNumber(seatModel);
        if(ticketDto.getTicketStatus().equals("CANCELED")||ticketDto.getTicketStatus().equals("POSTPONED")){
            ticketModel.setSeatNumber(null);
            ticketModel.setVehicle(null);
        }
        if(ticketService.saveTicketModel(ticketModel)){
            if(seatModel != null){
                seatModel.setStatus(seatService.getSeatStatus(Long.parseLong("1")));
                seatService.saveSeat(seatModel);
            }
            responseMessage.setStatus(true);
            responseMessage.setMessage("Bilet başarıyla güncellendi.");
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteTicket(String id) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Bilet silinirken bir hata oluştu.");
        if(ticketService.deleteTicketModel(Long.parseLong(id))){
            responseMessage.setStatus(true);
            responseMessage.setMessage("Bilet başarıyla silindi.");
        }
        return responseMessage;
    }
}
