package com.felece.ticket.facade;

import com.felece.ticket.dto.RouteDto;
import com.felece.ticket.request.RouteRequest;
import com.felece.ticket.response.ResponseMessage;
import com.felece.ticket.response.RouteResponse;

import java.util.List;

public interface RouteFacade {

    RouteResponse getRoute(String id);

    List<RouteDto> getAllRoutes();

    ResponseMessage saveRoute(RouteRequest routeRequest);

    ResponseMessage deleteRoute(String id);

    ResponseMessage updateRoute(RouteDto routeDto);
}
