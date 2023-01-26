package com.felece.ticket.service.impl;

import com.felece.ticket.dao.VehicleDao;
import com.felece.ticket.model.VehicleModel;
import com.felece.ticket.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public VehicleModel getVehicleModel(Long id) {
        return vehicleDao.getVehicleModel(id);
    }

    @Override
    public VehicleModel getVehicleModelByPlate(String plate) {
        return vehicleDao.getVehicleByPlate(plate);
    }

    @Override
    public List<VehicleModel> getAllVehicleModel() {
        return vehicleDao.getAllVehicleModel();
    }

    @Override
    public List<VehicleModel> getAllVehiclesByRoute(Long id) {
        return vehicleDao.getAllVehiclesByRoute(id);
    }

    @Override
    public Boolean saveVehicleModel(VehicleModel vehicleModel) {
        return vehicleDao.saveVehicleModel(vehicleModel);
    }

    @Override
    public Boolean deleteVehicleModel(Long id) {
        return vehicleDao.deleteVehicleModel(id);
    }
}
