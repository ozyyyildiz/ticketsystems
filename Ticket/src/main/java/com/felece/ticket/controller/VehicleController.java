package com.felece.ticket.controller;

import com.felece.ticket.dto.VehicleDto;
import com.felece.ticket.facade.VehicleFacade;
import com.felece.ticket.request.VehicleRequest;
import com.felece.ticket.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleFacade vehicleFacade;

    @RequestMapping(value = "/")
    public List<VehicleDto> getVehicles(){
        return vehicleFacade.getAllVehicleModel();
    }

    @RequestMapping(value = "/vehicle{id}")
    public VehicleDto getVehicle(@PathVariable("id") String id){
        return vehicleFacade.getVehicleModel(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createVehicle", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseMessage createVehicle(@RequestBody VehicleRequest vehicleRequest){
        return vehicleFacade.saveVehicleModel(vehicleRequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteVehicle{id}", produces = "application/json")
    @ResponseBody
    public ResponseMessage deleteVehicle(@PathVariable("id") String id){
        return vehicleFacade.deleteVehicleModel(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateVehicle", produces = "application/json")
    @ResponseBody
    public ResponseMessage updateVehicle(@RequestBody VehicleDto vehicleDto){
        return vehicleFacade.updateVehicleModel(vehicleDto);
    }
}
