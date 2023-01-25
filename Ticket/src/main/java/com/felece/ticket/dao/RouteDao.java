package com.felece.ticket.dao;

import com.felece.ticket.model.RouteModel;

import java.util.List;

public interface RouteDao {

    RouteModel getRouteModel(Long id);

    List<RouteModel> getAllRouteModels();

    Boolean saveRouteModel(RouteModel routeModel);

    Boolean deleteRouteModel(Long id);

    Boolean updateRoute(RouteModel routeModel);
}
