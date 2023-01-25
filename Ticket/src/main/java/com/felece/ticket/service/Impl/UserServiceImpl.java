package com.felece.ticket.service.Impl;

import com.felece.ticket.dao.UserDao;
import com.felece.ticket.model.UserModel;
import com.felece.ticket.model.UserRoleModel;
import com.felece.ticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserModel getUserModel(Long id) {
        return userDao.getUserModel(id);
    }

    @Override
    public List<UserModel> getAllUserModels() {
        return userDao.getAllUserModels();
    }

    @Override
    public Boolean saveUserModel(UserModel userModel) {
        return userDao.saveUserModel(userModel);
    }

    @Override
    public Boolean deleteUserModel(Long id) {
        return userDao.deleteUserModel(id);
    }

    @Override
    public UserRoleModel getUserRoleModel(Long id) {
        return userDao.getUserRoleModel(id);
    }

    @Override
    public Optional<UserModel> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userDao.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userDao.existsByEmail(email);
    }
}