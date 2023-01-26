package com.felece.ticket.facade;
import com.felece.ticket.response.SeatResponse;

import java.util.List;

public interface SeatFacade {

    List<SeatResponse> getAllEmptySeats();
}
