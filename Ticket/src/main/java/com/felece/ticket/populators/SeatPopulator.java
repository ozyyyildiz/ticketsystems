package com.felece.ticket.populators;

import com.felece.ticket.dto.SeatDto;
import com.felece.ticket.model.SeatModel;
import com.felece.ticket.request.SeatRequest;

public interface SeatPopulator {

    SeatDto modelToDto(SeatModel seatModel);

    SeatModel dtoToModel(SeatDto seatDto);

}
