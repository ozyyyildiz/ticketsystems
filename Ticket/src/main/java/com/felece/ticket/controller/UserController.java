package com.felece.ticket.controller;

import com.felece.ticket.dto.UserDto;
import com.felece.ticket.facade.UserFacade;
import com.felece.ticket.request.UserRequest;
import com.felece.ticket.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(method = RequestMethod.GET,value = "/")
    public List<UserDto> getAllUsers(){
        return userFacade.getAllUser();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/user/{id}")
    public UserDto getUser(@PathVariable("id") String id){
        return userFacade.getUser(id);
    }

    @RequestMapping (method = RequestMethod.POST, value = "/createUser", produces = "application/json")
    @ResponseBody
    public ResponseMessage saveUser(@RequestBody final UserRequest userRequest){
        return userFacade.saveUser(userRequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete{id}")
    public ResponseMessage deleteUser(@PathVariable("id") String id){
        return userFacade.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ResponseMessage updateUser(@RequestBody final UserDto userDto){
        return userFacade.updateUser(userDto);
    }
}
