package com.felece.ticket.populators;

import com.felece.ticket.dto.RouteDto;
import com.felece.ticket.model.RouteModel;
import com.felece.ticket.request.RouteRequest;

public interface RoutePopulator {

    RouteModel dtoToModel(RouteDto routeDto);

    RouteDto modelToDto(RouteModel routeModel);

    RouteModel dtoToModelForSave(RouteRequest routeRequest);
}
