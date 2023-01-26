package com.felece.ticket.dao.impl;

import com.felece.ticket.dao.TicketDao;
import com.felece.ticket.model.TicketModel;
import com.felece.ticket.model.TicketStatusModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(TicketDaoImpl.class);

    @Override
    public TicketModel getTicketModel(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.get(TicketModel.class, id);
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public List<TicketModel> getAllTicketModel() {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM TicketModel").list();
        }catch (Exception e){
            logger.error(e.toString());
            return Collections.emptyList();
        }
    }

    @Override
    public List<TicketModel> getTicketModelsByUsername(String username) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM TicketModel WHERE user.userName = :username")
                    .setParameter("username", username).getResultList();
        }catch (Exception e){
            logger.error(e.toString());
            return Collections.emptyList();
        }
    }

    @Override
    public List<TicketModel> getVehicleTicket(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM TicketModel WHERE vehicle.id =: id").setParameter("id",id).list();
        }catch (Exception e){
            logger.error(e.toString());
            return Collections.emptyList();
        }
    }

    @Override
    public TicketStatusModel getTicketStatus(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.load(TicketStatusModel.class, id);
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public TicketStatusModel getTicketStatusByName(String name) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (TicketStatusModel) session.createQuery("FROM TicketStatusModel WHERE ticketStatus =: name").setParameter("name",name).getSingleResult();
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public Boolean saveTicketModel(TicketModel ticketModel) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(ticketModel);
            return true;
        }catch (Exception e){
            logger.error(e.toString());
            return false;
        }
    }

    @Override
    public Boolean deleteTicketModel(Long id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(getTicketModel(id));
            return true;
        }catch (Exception e){
            logger.error(e.toString());
            return false;
        }
    }
}
