package com.felece.ticket.service.Impl;

import com.felece.ticket.dao.RouteDao;
import com.felece.ticket.model.RouteModel;
import com.felece.ticket.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    @Override
    public RouteModel getRouteModel(Long id) {
        return routeDao.getRouteModel(id);
    }

    @Override
    public List<RouteModel> getAllRouteModels() {
        return routeDao.getAllRouteModels();
    }

    @Override
    public Boolean saveRouteModel(RouteModel routeModel) {
        return routeDao.saveRouteModel(routeModel);
    }

    @Override
    public Boolean deleteRouteModel(Long id) {
        return routeDao.deleteRouteModel(id);
    }
}
