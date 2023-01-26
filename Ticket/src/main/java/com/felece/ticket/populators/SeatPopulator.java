package com.felece.ticket.populators;

import com.felece.ticket.dto.SeatDto;
import com.felece.ticket.model.SeatModel;

public interface SeatPopulator {

    SeatDto modelToDto(SeatModel seatModel);

    SeatModel dtoToModel(SeatDto seatDto);

}
