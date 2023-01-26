package com.felece.ticket.dao;

import com.felece.ticket.model.SeatModel;
import com.felece.ticket.model.SeatStatusModel;

import java.util.List;

public interface SeatDao {

    List<SeatModel> getAllVehicleSeats(Long id);

    List<SeatModel> getAllEmptySeats();

    SeatModel getSeatModel(Long id);

    SeatStatusModel getSeatStatus(Long id);

    SeatStatusModel getSeatStatusByName(String name);

    Boolean saveSeat(SeatModel seatModel);
}
