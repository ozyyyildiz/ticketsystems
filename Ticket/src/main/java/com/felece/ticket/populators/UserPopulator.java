package com.felece.ticket.populators;

import com.felece.ticket.dto.UserDto;
import com.felece.ticket.model.UserModel;
import com.felece.ticket.request.UserRequest;

public interface UserPopulator {

    UserModel dtoToModel(UserDto userDto);

    UserDto modelToDto(UserModel userModel);

    UserModel dtoToModelForSave(UserRequest userRequest);
}
