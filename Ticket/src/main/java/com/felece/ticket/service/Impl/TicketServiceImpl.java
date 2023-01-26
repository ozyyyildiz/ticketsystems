package com.felece.ticket.service.impl;

import com.felece.ticket.dao.TicketDao;
import com.felece.ticket.model.TicketModel;
import com.felece.ticket.model.TicketStatusModel;
import com.felece.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Override
    public TicketModel getTicketModel(Long id) {
        return ticketDao.getTicketModel(id);
    }

    @Override
    public List<TicketModel> getTicketModelsByUsername(String username) {
        return ticketDao.getTicketModelsByUsername(username);
    }

    @Override
    public List<TicketModel> getAllTicketModel() {
        return ticketDao.getAllTicketModel();
    }

    @Override
    public List<TicketModel> getVehicleTicket(Long id) {
        return ticketDao.getVehicleTicket(id);
    }

    @Override
    public TicketStatusModel getTicketStatus(Long id) {
        return ticketDao.getTicketStatus(id);
    }

    @Override
    public TicketStatusModel getTicketStatusByName(String name) {
        return ticketDao.getTicketStatusByName(name);
    }

    @Override
    public Boolean saveTicketModel(TicketModel ticketModel) {
        return ticketDao.saveTicketModel(ticketModel);
    }

    @Override
    public Boolean deleteTicketModel(Long id) {
        return ticketDao.deleteTicketModel(id);
    }
}
