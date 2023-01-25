package com.felece.ticket.populators;

import com.felece.ticket.dto.VehicleDto;
import com.felece.ticket.model.VehicleModel;
import com.felece.ticket.request.VehicleRequest;

public interface VehiclePopulator {

    VehicleModel dtoToModel(VehicleDto vehicleDto);

    VehicleDto modelToDto(VehicleModel vehicleModel);

    VehicleModel dtoToModelForSave(VehicleRequest vehicleRequest);
}
