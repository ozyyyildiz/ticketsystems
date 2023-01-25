package com.felece.ticket.facade.Impl;

import com.felece.ticket.dto.RouteDto;
import com.felece.ticket.dto.VehicleDto;
import com.felece.ticket.facade.RouteFacade;
import com.felece.ticket.model.RouteModel;
import com.felece.ticket.model.VehicleModel;
import com.felece.ticket.populators.RoutePopulator;
import com.felece.ticket.populators.VehiclePopulator;
import com.felece.ticket.request.RouteRequest;
import com.felece.ticket.request.VehicleRequest;
import com.felece.ticket.response.ResponseMessage;
import com.felece.ticket.response.RouteResponse;
import com.felece.ticket.service.RouteService;
import com.felece.ticket.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class RouteFacadeImpl implements RouteFacade {

    @Autowired
    private RouteService routeService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehiclePopulator vehiclePopulator;

    @Autowired
    private RoutePopulator routePopulator;


    @Override
    public RouteResponse getRoute(String id) {
        RouteResponse routeResponse = new RouteResponse();
        RouteModel routeModel = routeService.getRouteModel(Long.parseLong(id));
        routeResponse.setId(String.valueOf(routeModel.getId()));
        routeResponse.setFromCity(routeModel.getFromCity());
        routeResponse.setToCity(routeModel.getToCity());
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        vehicleService.getAllVehiclesByRoute(routeModel.getId()).stream().forEach(vehicleModel -> {
            vehicleDtoList.add(vehiclePopulator.modelToDto(vehicleModel));
        });
        if(!vehicleDtoList.isEmpty()){
            routeResponse.setVehicleDtoList(vehicleDtoList);
        }
        return routeResponse;
    }

    @Override
    public List<RouteDto> getAllRoutes() {
        List<RouteDto> routeDtoList = new ArrayList<>();
        routeService.getAllRouteModels().stream().forEach(routeModel -> {
            routeDtoList.add(routePopulator.modelToDto(routeModel));
        });
        return routeDtoList;
    }

    @Override
    public ResponseMessage saveRoute(RouteRequest routeRequest) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Rota bilgileri eklenirken bir hata oluştu.");
        if(Stream.of(routeRequest.getFromCity(), routeRequest.getToCity()).allMatch(Objects::isNull) ||
                (routeRequest.getFromCity().isEmpty() || routeRequest.getToCity().isEmpty())){
            return responseMessage;
        }
        RouteModel routeModel = routePopulator.dtoToModelForSave(routeRequest);
        if(routeService.saveRouteModel(routeModel)){
            responseMessage.setStatus(true);
            responseMessage.setMessage("Rota başarıyla oluşturuldu.");
            return responseMessage;
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteRoute(String id) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Rota silinirken bir hata oluştu");
        if(id == null || id.isEmpty()){
            responseMessage.setStatus(false);
            responseMessage.setMessage("Silmek istediğiniz rota bulunamadı.");
        }
        List<VehicleModel> vehicleModelList = vehicleService.getAllVehiclesByRoute(Long.parseLong(id));
        vehicleModelList.stream().forEach(vehicleModel -> {
            vehicleModel.setRoute(null);
            vehicleService.saveVehicleModel(vehicleModel);
        });
        if(routeService.deleteRouteModel(Long.parseLong(id))){
            responseMessage.setStatus(true);
            responseMessage.setMessage("Rota başarıyla silindi.");
            return responseMessage;
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage updateRoute(RouteDto routeDto) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Rota bilgileri güncellenirken bir hata oluştu");
        if(Stream.of(routeDto.getId(), routeDto.getFromCity(), routeDto.getToCity()).allMatch(Objects::isNull) ||
        routeDto.getId().isEmpty() || routeDto.getFromCity().isEmpty() || routeDto.getToCity().isEmpty()){
            return responseMessage;
        }
        RouteModel routeModel = routePopulator.dtoToModel(routeDto);
        if(routeService.saveRouteModel(routeModel)){
            responseMessage.setStatus(true);
            responseMessage.setMessage("Rota bilgileri başarıyla güncellendi");
        }
        return responseMessage;
    }
}
