package com.felece.ticket.dao;

import com.felece.ticket.model.UserModel;
import com.felece.ticket.model.UserRoleModel;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    UserModel getUserModel(Long id);

    List<UserModel> getAllUserModels();

    Boolean saveUserModel(UserModel userModel);

    Boolean deleteUserModel(Long id);

    UserRoleModel getUserRoleModel(Long id);

    Optional<UserModel> findByUsername(String username);

    UserModel getByUsername(String username);

    Boolean existsByEmail(String email);

}
