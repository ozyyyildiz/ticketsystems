package com.felece.ticket.service;

import com.felece.ticket.model.TicketModel;
import com.felece.ticket.model.TicketStatusModel;

import java.util.List;

public interface TicketService {

    TicketModel getTicketModel(Long id);

    List<TicketModel> getTicketModelsByUsername(String username);

    List<TicketModel> getAllTicketModel();

    List<TicketModel> getVehicleTicket(Long id);

    TicketStatusModel getTicketStatus(Long id);

    TicketStatusModel getTicketStatusByName(String name);

    Boolean saveTicketModel(TicketModel ticketModel);

    Boolean deleteTicketModel(Long id);

}
