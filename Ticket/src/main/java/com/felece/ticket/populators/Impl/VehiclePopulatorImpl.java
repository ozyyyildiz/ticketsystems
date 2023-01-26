package com.felece.ticket.populators.impl;

import com.felece.ticket.dto.SeatDto;
import com.felece.ticket.dto.VehicleDto;
import com.felece.ticket.model.SeatModel;
import com.felece.ticket.model.VehicleModel;
import com.felece.ticket.populators.RoutePopulator;
import com.felece.ticket.populators.SeatPopulator;
import com.felece.ticket.populators.VehiclePopulator;
import com.felece.ticket.request.VehicleRequest;
import com.felece.ticket.service.RouteService;
import com.felece.ticket.service.SeatService;
import com.felece.ticket.utils.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class VehiclePopulatorImpl implements VehiclePopulator {

    @Autowired
    private SeatService seatService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private RoutePopulator routePopulator;

    @Autowired
    private SeatPopulator seatPopulator;

    @Override
    public VehicleModel dtoToModel(VehicleDto vehicleDto) {
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setId(Long.parseLong(vehicleDto.getId()));
        vehicleModel.setLicensePlate(vehicleDto.getLicensePlate());
        vehicleModel.setExpTime(DateConverter.stringToDate(vehicleDto.getExpTime()));
        Set<SeatModel> seatModelSet = new HashSet<>();
        vehicleDto.getSeatDto().forEach(seatDto -> seatModelSet.add(seatService.getSeatModel(Long.parseLong(seatDto.getId()))));
        vehicleModel.setSeatModels(seatModelSet);
        vehicleModel.setRoute(routeService.getRouteModel(Long.parseLong(vehicleDto.getRouteDto().getId())));
        return vehicleModel;
    }

    @Override
    public VehicleDto modelToDto(VehicleModel vehicleModel) {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(String.valueOf(vehicleModel.getId()));
        vehicleDto.setLicensePlate(vehicleModel.getLicensePlate());
        vehicleDto.setExpTime(DateConverter.dateToString(vehicleModel.getExpTime()));
        if(vehicleModel.getRoute() != null){
            vehicleDto.setRouteDto(routePopulator.modelToDto(vehicleModel.getRoute()));
        }
        List<SeatDto> seatDtoList = new ArrayList<>();
        vehicleModel.getSeatModels().forEach(seatModel -> seatDtoList.add(seatPopulator.modelToDto(seatModel)));
        Collections.sort(seatDtoList, Comparator.comparing(SeatDto::getSeatNumber));
        vehicleDto.setSeatDto(seatDtoList);
        return vehicleDto;
    }

    @Override
    public VehicleModel dtoToModelForSave(VehicleRequest vehicleRequest) {
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setLicensePlate(vehicleRequest.getLicensePlate());
        vehicleModel.setExpTime(DateConverter.stringToDate(vehicleRequest.getExpTime()));
        vehicleModel.setRoute(routeService.getRouteModel(Long.parseLong(vehicleRequest.getRoute())));
        return vehicleModel;
    }
}
