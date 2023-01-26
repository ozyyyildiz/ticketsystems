package com.felece.ticket.dao.impl;

import com.felece.ticket.dao.UserDao;
import com.felece.ticket.model.UserModel;
import com.felece.ticket.model.UserRoleModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private static final String GET_USER_BY_USERNAME = "FROM UserModel WHERE userName = :username";

    @Override
    public UserModel getUserModel(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.load(UserModel.class, id);
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public List<UserModel> getAllUserModels() {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM UserModel ").list();
        }catch (Exception e){
            logger.error(e.toString());
            return Collections.emptyList();
        }
    }

    @Override
    public Boolean saveUserModel(UserModel userModel) {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(userModel);
            return true;
        }catch (Exception e){
            logger.error(e.toString());
            return false;
        }
    }

    @Override
    public Boolean deleteUserModel(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(getUserModel(id));
            return true;
        }catch (Exception e){
            logger.error(e.toString());
            return false;
        }
    }

    @Override
    public UserRoleModel getUserRoleModel(Long id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.load(UserRoleModel.class, id);
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public Optional<UserModel> findByUsername(String username) {
        try{
            Session session = sessionFactory.getCurrentSession();
            List<UserModel> users = session.createQuery(GET_USER_BY_USERNAME)
                    .setParameter("username", username).list();
            return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
        }catch (Exception e){
            logger.error(e.toString());
            return Optional.empty();
        }
    }

    @Override
    public UserModel getByUsername(String username) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (UserModel) session.createQuery(GET_USER_BY_USERNAME)
                    .setParameter("username", username).getSingleResult();
        }catch (Exception e){
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public Boolean existsByEmail(String email) {
        try{
            Session session = sessionFactory.getCurrentSession();
            UserModel userModel = (UserModel) session.createQuery("FROM UserModel WHERE email = :email").setParameter("email", email).getSingleResult();
            return userModel != null;
        }catch (Exception e){
            logger.error(e.toString());
            return false;
        }
    }
}
