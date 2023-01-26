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

    @GetMapping(value = "/")
    public List<TicketDto> getTicketList(){
        return ticketFacade.getAllTickets();
    }

    @GetMapping(value = "/userTicket/{username}")
    public List<TicketDto> getUserTicketList(@PathVariable String username){
        return ticketFacade.getTicketByUsername(username);
    }

    @GetMapping(value = "/ticket/{id}")
    public TicketDto getTicket(@PathVariable("id") String id){
        return ticketFacade.getTicket(id);
    }

    @PostMapping(value = "/saveTicket", produces = "application/json")
    @ResponseBody
    public ResponseMessage saveTicket(@RequestBody TicketRequest ticketRequest){
        return ticketFacade.saveTicket(ticketRequest);
    }

    @PostMapping(value = "/updateTicket")
    @ResponseBody
    public ResponseMessage updateTicket(@RequestBody TicketDto ticketDto){
        return ticketFacade.updateTicket(ticketDto);
    }

    @PostMapping(value = "/deleteTicket{id}")
    @ResponseBody
    public ResponseMessage deleteTicket(@PathVariable("id") String id){
        return ticketFacade.deleteTicket(id);
    }
}
