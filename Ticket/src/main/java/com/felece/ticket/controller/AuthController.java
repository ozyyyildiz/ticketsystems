package com.felece.ticket.controller;

import com.felece.ticket.auth.TokenManager;
import com.felece.ticket.facade.UserFacade;
import com.felece.ticket.request.LoginRequest;
import com.felece.ticket.request.UserRequest;
import com.felece.ticket.response.AuthResponse;
import com.felece.ticket.response.ResponseMessage;
import com.felece.ticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/authentication")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    @ResponseBody
    public ResponseMessage register(@RequestBody UserRequest userRequest){
        ResponseMessage responseMessage = new ResponseMessage();
        if(userService.existsByUsername(userRequest.getUserName()) || userService.existsByEmail(userRequest.getEmail())){
            responseMessage.setStatus(false);
            responseMessage.setMessage("Kullanıcı adı ya da email kullanımda");
            return responseMessage;
        }
        userFacade.saveUser(userRequest);
        responseMessage.setStatus(true);
        responseMessage.setMessage("Kullanıcı Oluşturuldu");
        return responseMessage;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenManager.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponse(token), HttpStatus.OK);
    }
}
