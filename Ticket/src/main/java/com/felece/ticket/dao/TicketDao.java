package com.felece.ticket.dao;

import com.felece.ticket.model.TicketModel;
import com.felece.ticket.model.TicketStatusModel;

import java.util.List;

public interface TicketDao {

    TicketModel getTicketModel(Long id);

    List<TicketModel> getAllTicketModel();

    List<TicketModel> getTicketModelsByUserId(Long id);

    List<TicketModel> getVehicleTicket(Long id);

    TicketStatusModel getTicketStatus(Long id);

    TicketStatusModel getTicketStatusByName(String name);


    Boolean saveTicketModel(TicketModel ticketModel);

    Boolean deleteTicketModel(Long id);
}
