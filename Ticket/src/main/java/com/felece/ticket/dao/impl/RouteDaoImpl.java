package com.felece.ticket.dao.impl;

import com.felece.ticket.dao.RouteDao;
import com.felece.ticket.model.RouteModel;
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
public class RouteDaoImpl implements RouteDao {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(RouteDaoImpl.class);

    @Override
    public RouteModel getRouteModel(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.load(RouteModel.class, id);
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public List<RouteModel> getAllRouteModels() {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM RouteModel ").list();
        }catch (Exception e){
            logger.error(e.toString());
            return Collections.emptyList();
        }
    }

    @Override
    public Boolean saveRouteModel(RouteModel routeModel) {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(routeModel);
            return true;
        }catch (Exception e){
            logger.error(e.toString());
            return false;
        }
    }

    @Override
    public Boolean deleteRouteModel(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(getRouteModel(id));
            return true;
        }catch (Exception e){
            logger.error(e.toString());
            return false;
        }
    }

    @Override
    public Boolean updateRoute(RouteModel routeModel) {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.update(routeModel);
            return true;
        }catch (Exception e){
            logger.error(e.toString());
            return false;
        }
    }
}
