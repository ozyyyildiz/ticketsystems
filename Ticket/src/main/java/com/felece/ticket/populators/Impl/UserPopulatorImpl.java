package com.felece.ticket.populators.Impl;

import com.felece.ticket.dto.UserDto;
import com.felece.ticket.dto.UserRoleDto;
import com.felece.ticket.model.UserModel;
import com.felece.ticket.model.UserRoleModel;
import com.felece.ticket.populators.UserPopulator;
import com.felece.ticket.request.UserRequest;
import com.felece.ticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserPopulatorImpl implements UserPopulator {

    private static final String DEFROLE = "2";

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserModel dtoToModel(UserDto userDto) {

        UserModel userModel = new UserModel();
        userModel.setId(Long.parseLong(userDto.getId()));
        userModel.setUserName(userDto.getUserName());
        userModel.setEmail(userDto.getEmail());
        userModel.setPassword(userDto.getPassword());
        userModel.setRole(userService.getUserRoleModel(Long.parseLong(userDto.getUserRole())));
        return userModel;
    }

    @Override
    public UserDto modelToDto(UserModel userModel) {
        UserDto userDto = new UserDto();
        userDto.setId(String.valueOf(userModel.getId()));
        userDto.setUserName(userModel.getUserName());
        userDto.setEmail(userModel.getEmail());
        userDto.setPassword(userModel.getPassword());
        userDto.setUserRole(String.valueOf(userModel.getRole().getId()));
        return userDto;
    }

    @Override
    public UserModel dtoToModelForSave(UserRequest userRequest) {
        UserModel userModel = new UserModel();
        userModel.setUserName(userRequest.getUserName());
        userModel.setEmail(userRequest.getEmail());
        userModel.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        if(userRequest.getUserRole() != null){
            userModel.setRole(userService.getUserRoleModel(Long.parseLong(userRequest.getUserRole())));
        }else{
            userModel.setRole(userService.getUserRoleModel(Long.parseLong(DEFROLE)));
        }
        return userModel;
    }
}
