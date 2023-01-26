package com.felece.ticket.facade.Impl;

import com.felece.ticket.dto.VehicleDto;
import com.felece.ticket.facade.VehicleFacade;
import com.felece.ticket.model.SeatModel;
import com.felece.ticket.model.VehicleModel;
import com.felece.ticket.populators.VehiclePopulator;
import com.felece.ticket.request.VehicleRequest;
import com.felece.ticket.response.ResponseMessage;
import com.felece.ticket.service.SeatService;
import com.felece.ticket.service.TicketService;
import com.felece.ticket.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleFacadeImpl implements VehicleFacade {

    private static final String DEF_STATUS = "EMPTY";

    private static final String TICKET_STATUS_CANCELED = "CANCELED";

    @Autowired
    private VehiclePopulator vehiclePopulator;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private TicketService ticketService;

    @Override
    public VehicleDto getVehicleModel(String id) {
        VehicleModel vehicleModel = vehicleService.getVehicleModel(Long.parseLong(id));
        VehicleDto vehicleDto = vehiclePopulator.modelToDto(vehicleModel);
        return vehicleDto;
    }

    @Override
    public List<VehicleDto> getAllVehicleModel() {
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        vehicleService.getAllVehicleModel().stream().forEach(vehicleModel -> {
            vehicleDtoList.add(vehiclePopulator.modelToDto(vehicleModel));
        });
        return vehicleDtoList;
    }

    @Override
    public ResponseMessage saveVehicleModel(VehicleRequest vehicleRequest) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Araç oluşturulurken bir hata oluştu.");
        if(vehicleService.getVehicleModelByPlate(vehicleRequest.getLicensePlate()) != null ){
            responseMessage.setStatus(false);
            responseMessage.setMessage("Girdiğiniz plaka başka bir araca ait. Lütfen araç bilgilerini güncelleyiniz.");
            return responseMessage;
        }
        VehicleModel vehicleModel = vehiclePopulator.dtoToModelForSave(vehicleRequest);
        if(vehicleService.saveVehicleModel(vehicleModel)){
            for(int i = 1; i<=vehicleRequest.getSeatCount(); i++){
                SeatModel seatModel = new SeatModel();
                if (i < 10) {
                    seatModel.setSeatNumber("0" + String.valueOf(i));
                } else {
                    seatModel.setSeatNumber(String.valueOf(i));
                }
                seatModel.setStatus(seatService.getSeatStatusByName(DEF_STATUS));
                seatModel.setVehicle(vehicleService.getVehicleModelByPlate(vehicleRequest.getLicensePlate()));
                seatService.saveSeat(seatModel);
            }
            responseMessage.setStatus(true);
            responseMessage.setMessage("Araç başarıyla kaydedildi.");
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteVehicleModel(String id) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Araç silinirken bir hata oluştu.");

        if(!ticketService.getVehicleTicket(Long.parseLong(id)).isEmpty()){
            ticketService.getVehicleTicket(Long.parseLong(id)).stream().forEach(ticketModel -> {
                ticketService.deleteTicketModel(ticketModel.getId());
                ticketModel.setTicketStatus(ticketService.getTicketStatusByName(TICKET_STATUS_CANCELED));
            });
        }
        if(vehicleService.deleteVehicleModel(Long.parseLong(id))){
            responseMessage.setStatus(true);
            responseMessage.setMessage("Araç başarıyla silindi");
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage updateVehicleModel(VehicleDto vehicleDto) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Araç güncellenirken bir hata oluştu.");
        VehicleModel vehicleModel = vehiclePopulator.dtoToModel(vehicleDto);
        if(vehicleService.saveVehicleModel(vehicleModel)){
            responseMessage.setStatus(true);
            responseMessage.setMessage("Araç başarıyla güncellendi");
        }
        return responseMessage;
    }
}
