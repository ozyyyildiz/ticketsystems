package com.felece.ticket.facade;

import com.felece.ticket.dto.SeatDto;
import com.felece.ticket.request.SeatRequest;

import java.util.List;

public interface SeatFacade {

    SeatDto getSeat(String id);

    List<SeatDto> getAllSeats();

    List<SeatDto> getAllSeatsOfVehicle(String id);

    Boolean saveSeat(SeatRequest seatRequest);

    Boolean updateSeat(SeatDto seatDto);
}
