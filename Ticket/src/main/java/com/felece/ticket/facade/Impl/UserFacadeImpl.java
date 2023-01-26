package com.felece.ticket.facade.impl;

import com.felece.ticket.dto.UserDto;
import com.felece.ticket.facade.UserFacade;
import com.felece.ticket.model.UserModel;
import com.felece.ticket.populators.UserPopulator;
import com.felece.ticket.request.UserRequest;
import com.felece.ticket.response.ResponseMessage;
import com.felece.ticket.service.TicketService;
import com.felece.ticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private UserPopulator userPopulator;

    @Autowired
    private TicketService ticketService;


    @Override
    public UserDto getUser(String id) {
        return userPopulator.modelToDto(userService.getUserModel(Long.parseLong(id)));
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> userDtoList = new ArrayList<>();
        userService.getAllUserModels().forEach(userModel -> userDtoList.add(userPopulator.modelToDto(userModel)));
        return userDtoList;
    }

    @Override
    public ResponseMessage saveUser(UserRequest userRequest) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Kullanıcı oluşturulurken bir hata oluştu.");
        UserModel userModel = userPopulator.dtoToModelForSave(userRequest);
        if(userService.saveUserModel(userModel)){
            responseMessage.setStatus(true);
            responseMessage.setMessage("Bilet başarıyla silindi.");
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteUser(String id) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Kullanıcı silinirken bir hata oluştu.");
//        UserModel userModel = userService.getUserModel(Long.parseLong(id));
//
//        ticketService.getTicketModelsByUsername(userModel.getUserName());
        if(userService.deleteUserModel(Long.parseLong(id))){
            responseMessage.setStatus(true);
            responseMessage.setMessage("Kullanıcı başarıyla silindi.");
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage updateUser(UserDto userDto) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(false);
        responseMessage.setMessage("Kullanıcı bilgileri güncellenirken bir hata oluştu.");
        UserModel userModel = userPopulator.dtoToModel(userDto);
        if(userService.saveUserModel(userModel)){
            responseMessage.setStatus(true);
            responseMessage.setMessage("Kullanıcı başarıyla güncellendi.");
        }
        return responseMessage;
    }
}
