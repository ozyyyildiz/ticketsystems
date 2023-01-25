package com.felece.ticket.facade;

import com.felece.ticket.dto.VehicleDto;
import com.felece.ticket.request.VehicleRequest;
import com.felece.ticket.response.ResponseMessage;

import java.util.List;

public interface VehicleFacade {

    VehicleDto getVehicleModel(String id);

    List<VehicleDto> getAllVehicleModel();

    ResponseMessage saveVehicleModel(VehicleRequest vehicleRequest);

    ResponseMessage deleteVehicleModel(String id);

    ResponseMessage updateVehicleModel(VehicleDto vehicleDto);

}
