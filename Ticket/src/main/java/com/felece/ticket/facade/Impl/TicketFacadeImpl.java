package com.felece.ticket.facade.Impl;

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
import java.util.stream.Stream;

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
        TicketModel ticketModel = ticketService.getTicketModel(Long.parseLong(id));
        TicketDto ticketDto = ticketPopulator.modelToDto(ticketModel);
        return ticketDto;
    }

    @Override
    public List<TicketDto> getTicketByUserId(String id) {
        List<TicketDto> ticketDtoList = new ArrayList<>();
        ticketService.getTicketModelsByUserId(Long.parseLong(id)).stream().forEach(ticketModel -> {
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
            SeatModel seatModel = ticketModel.getSeatNumber();
            if(ticketRequest.getTicketStatus()=="RESERVED"){
                seatModel.setStatus(seatService.getSeatStatusByName("RESERVED"));
            }else if(ticketRequest.getTicketStatus()=="PURCHASED"){
                seatModel.setStatus(seatService.getSeatStatusByName("OCCUPIED"));
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
        TicketModel ticketModel = ticketPopulator.dtoToModel(ticketDto);
        if(ticketService.saveTicketModel(ticketModel)){
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
