package com.felece.ticket.populators.impl;

import com.felece.ticket.dto.RouteDto;
import com.felece.ticket.model.RouteModel;
import com.felece.ticket.populators.RoutePopulator;
import com.felece.ticket.request.RouteRequest;

public class RoutePopulatorImpl implements RoutePopulator {

    @Override
    public RouteModel dtoToModel(RouteDto routeDto) {
        RouteModel routeModel = new RouteModel();
        routeModel.setId(Long.parseLong(routeDto.getId()));
        routeModel.setFromCity(routeDto.getFromCity());
        routeModel.setToCity(routeDto.getToCity());
        return routeModel;
    }

    @Override
    public RouteDto modelToDto(RouteModel routeModel) {
        RouteDto routeDto = new RouteDto();
        routeDto.setId(String.valueOf(routeModel.getId()));
        routeDto.setFromCity(routeModel.getFromCity());
        routeDto.setToCity(routeModel.getToCity());
        return routeDto;
    }

    @Override
    public RouteModel dtoToModelForSave(RouteRequest routeRequest) {
        RouteModel routeModel = new RouteModel();
        routeModel.setFromCity(routeRequest.getFromCity());
        routeModel.setToCity(routeRequest.getToCity());
        return routeModel;
    }
}
