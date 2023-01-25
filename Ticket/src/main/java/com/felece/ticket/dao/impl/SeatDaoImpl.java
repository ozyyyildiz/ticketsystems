package com.felece.ticket.dao.impl;

import com.felece.ticket.dao.SeatDao;
import com.felece.ticket.model.SeatModel;
import com.felece.ticket.model.SeatStatusModel;
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
public class SeatDaoImpl implements SeatDao {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(SeatDaoImpl.class);

    @Override
    public List<SeatModel> getAllVehicleSeats(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM SeatModel WHERE vehicle.id=:id").setParameter("id", id).list();
        }catch (Exception e){
            logger.error(e.toString());
            return Collections.emptyList();
        }
    }

    @Override
    public List<SeatModel> getAllSeats() {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM SeatModel").list();
        }catch (Exception e){
            logger.error(e.toString());
            return Collections.emptyList();
        }
    }

    @Override
    public SeatModel getSeatModel(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.load(SeatModel.class, id);
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public SeatStatusModel getSeatStatus(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.load(SeatStatusModel.class, id);
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public SeatStatusModel getSeatStatusByName(String name) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (SeatStatusModel) session.createQuery("FROM SeatStatusModel WHERE seatStatus=:name").setParameter("name",name).getSingleResult();
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public Boolean saveSeat(SeatModel seatModel) {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(seatModel);
            return true;
        }catch (Exception e){
            logger.error(e.toString());
            return false;
        }
    }

}
