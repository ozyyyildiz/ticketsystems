package com.felece.ticket.dao.impl;

import com.felece.ticket.dao.VehicleDao;
import com.felece.ticket.model.VehicleModel;
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
public class VehicleDaoImpl implements VehicleDao {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(VehicleDaoImpl.class);


    @Override
    public VehicleModel getVehicleModel(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.load(VehicleModel.class, id);
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public VehicleModel getVehicleByPlate(String plate) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (VehicleModel) session.createQuery("FROM VehicleModel WHERE licensePlate =: plate").setParameter("plate", plate).getSingleResult();
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public List<VehicleModel> getAllVehicleModel() {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM VehicleModel").list();
        }catch (Exception e){
            logger.error(e.toString());
            return Collections.emptyList();
        }
    }

    @Override
    public List<VehicleModel> getAllVehiclesByRoute(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM VehicleModel WHERE route.id = :id").setParameter("id", id).list();
        }catch (Exception e){
            logger.error(e.toString());
            return Collections.emptyList();
        }
    }

    @Override
    public Boolean saveVehicleModel(VehicleModel vehicleModel) {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(vehicleModel);
            return true;
        }catch (Exception e){
            logger.error(e.toString());
            return false;
        }
    }

    @Override
    public Boolean deleteVehicleModel(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(getVehicleModel(id));
            return true;
        }catch (Exception e){
            logger.error(e.toString());
            return false;
        }
    }
}
