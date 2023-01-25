package com.felece.ticket.facade;

import com.felece.ticket.dto.UserDto;
import com.felece.ticket.dto.UserRoleDto;
import com.felece.ticket.request.UserRequest;
import com.felece.ticket.response.ResponseMessage;

import java.util.List;

public interface UserFacade {

    UserDto getUser(String id);

    List<UserDto> getAllUser();

    ResponseMessage saveUser(UserRequest userRequest);

    ResponseMessage deleteUser(String id);

    ResponseMessage updateUser(UserDto userDto);
}
