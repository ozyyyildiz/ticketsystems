package com.felece.ticket.controller;

import com.felece.ticket.dto.RouteDto;
import com.felece.ticket.facade.RouteFacade;
import com.felece.ticket.request.RouteRequest;
import com.felece.ticket.response.ResponseMessage;
import com.felece.ticket.response.RouteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials="true")
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteFacade routeFacade;

    @RequestMapping(value = "/")
    public List<RouteDto> getRoutes(){
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return routeFacade.getAllRoutes();
    }

    @RequestMapping(value = "/route/{id}")
    public RouteResponse getRoute(@PathVariable("id") String id){
        return routeFacade.getRoute(id);
    }

    @RequestMapping (method = RequestMethod.POST, value = "/createRoute", produces = "application/json")
    @ResponseBody
    public ResponseMessage saveRoute(@RequestBody final RouteRequest routeRequest){
        return routeFacade.saveRoute(routeRequest);
    }

    @RequestMapping (method = RequestMethod.POST, value = "/updateRoute", produces = "application/json")
    @ResponseBody
    public ResponseMessage updateRoute(@RequestBody final RouteDto routeDto){
        return routeFacade.updateRoute(routeDto);
    }

    @RequestMapping (method = RequestMethod.POST, value = "/deleteRoute{id}", produces = "application/json")
    @ResponseBody
    public ResponseMessage deleteRoute(@PathVariable("id") String id){
        return routeFacade.deleteRoute(id);
    }
}
