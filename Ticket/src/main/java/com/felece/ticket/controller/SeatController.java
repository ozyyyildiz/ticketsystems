package com.felece.ticket.controller;

import com.felece.ticket.facade.SeatFacade;
import com.felece.ticket.response.SeatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatFacade seatFacade;

    @GetMapping(value = "/")
    public List<SeatResponse> gelAllEmptySeats(){
        return seatFacade.getAllEmptySeats();
    }
}
