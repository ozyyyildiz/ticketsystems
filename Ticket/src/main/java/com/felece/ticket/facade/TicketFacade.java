package com.felece.ticket.facade;

import com.felece.ticket.dto.TicketDto;
import com.felece.ticket.request.TicketRequest;
import com.felece.ticket.response.ResponseMessage;

import java.util.List;

public interface TicketFacade {

    TicketDto getTicket(String id);

    List<TicketDto> getTicketByUsername(String username);

    List<TicketDto> getAllTickets();

    ResponseMessage saveTicket(TicketRequest ticketRequest);

    ResponseMessage updateTicket(TicketDto ticketDto);

    ResponseMessage deleteTicket(String id);

}
