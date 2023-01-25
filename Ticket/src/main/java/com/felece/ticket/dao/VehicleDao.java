package com.felece.ticket.dao;

import com.felece.ticket.model.VehicleModel;

import java.util.List;

public interface VehicleDao {

    VehicleModel getVehicleModel(Long id);

    VehicleModel getVehicleByPlate(String plate);

    List<VehicleModel> getAllVehicleModel();

    List<VehicleModel> getAllVehiclesByRoute(Long id);

    Boolean saveVehicleModel(VehicleModel vehicleModel);

    Boolean deleteVehicleModel(Long id);
}
