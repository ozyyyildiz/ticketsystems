package com.felece.ticket.service.Impl;

import com.felece.ticket.dao.SeatDao;
import com.felece.ticket.model.SeatModel;
import com.felece.ticket.model.SeatStatusModel;
import com.felece.ticket.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatDao seatDao;

    @Override
    public List<SeatModel> getAllVehicleSeats(Long id) {
        return seatDao.getAllVehicleSeats(id);
    }

    @Override
    public List<SeatModel> getAllEmptySeats() {
        return seatDao.getAllEmptySeats();
    }

    @Override
    public SeatModel getSeatModel(Long id) {
        return seatDao.getSeatModel(id);
    }

    @Override
    public SeatStatusModel getSeatStatus(Long id) {
        return seatDao.getSeatStatus(id);
    }

    @Override
    public SeatStatusModel getSeatStatusByName(String name) {
        return seatDao.getSeatStatusByName(name);
    }

    @Override
    public Boolean saveSeat(SeatModel seatModel) {
        return seatDao.saveSeat(seatModel);
    }
}
