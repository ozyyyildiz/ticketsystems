package com.felece.ticket.controller;

import com.felece.ticket.dto.TicketDto;
import com.felece.ticket.facade.TicketFacade;
import com.felece.ticket.request.TicketRequest;
import com.felece.ticket.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketFacade ticketFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<TicketDto> getTicketList(){
        return ticketFacade.getAllTickets();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userTicket/{id}")
    public List<TicketDto> getUserTicketList(@PathVariable("id") String id){
        return ticketFacade.getTicketByUserId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ticket/{id}")
    public TicketDto getTicket(@PathVariable("id") String id){
        return ticketFacade.getTicket(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveTicket")
    public ResponseMessage saveTicket(@RequestBody TicketRequest ticketRequest){
        return ticketFacade.saveTicket(ticketRequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateTicket")
    public ResponseMessage updateTicket(@RequestBody TicketDto ticketDto){
        return ticketFacade.updateTicket(ticketDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteTicket{id}")
    public ResponseMessage deleteTicket(@PathVariable("id") String id){
        return ticketFacade.deleteTicket(id);
    }
}
