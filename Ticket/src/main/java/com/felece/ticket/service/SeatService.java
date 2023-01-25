package com.felece.ticket.service;

import com.felece.ticket.model.SeatModel;
import com.felece.ticket.model.SeatStatusModel;

import java.util.List;

public interface SeatService {

    List<SeatModel> getAllVehicleSeats(Long id);

    List<SeatModel> getAllSeats();

    SeatModel getSeatModel(Long id);

    SeatStatusModel getSeatStatus(Long id);

    SeatStatusModel getSeatStatusByName(String name);

    Boolean saveSeat(SeatModel seatModel);
}
