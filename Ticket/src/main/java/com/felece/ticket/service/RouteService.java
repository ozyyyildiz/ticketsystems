package com.felece.ticket.service;

import com.felece.ticket.model.RouteModel;

import java.util.List;

public interface RouteService {

    RouteModel getRouteModel(Long id);

    List<RouteModel> getAllRouteModels();

    Boolean saveRouteModel(RouteModel routeModel);

    Boolean deleteRouteModel(Long id);

}
