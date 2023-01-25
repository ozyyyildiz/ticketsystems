package com.felece.ticket.populators;

import com.felece.ticket.dto.TicketDto;
import com.felece.ticket.model.TicketModel;
import com.felece.ticket.request.TicketRequest;

public interface TicketPopulator {

    TicketDto modelToDto (TicketModel ticketModel);

    TicketModel dtoToModel (TicketDto ticketDto);

    TicketModel dtoToModelForSave (TicketRequest ticketRequest);

}
