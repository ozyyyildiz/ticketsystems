package com.felece.ticket.service;

import com.felece.ticket.model.VehicleModel;

import java.util.List;

public interface VehicleService {

    VehicleModel getVehicleModel(Long id);

    VehicleModel getVehicleModelByPlate(String plate);

    List<VehicleModel> getAllVehicleModel();

    List<VehicleModel> getAllVehiclesByRoute(Long id);

    Boolean saveVehicleModel(VehicleModel vehicleModel);

    Boolean deleteVehicleModel(Long id);
}
