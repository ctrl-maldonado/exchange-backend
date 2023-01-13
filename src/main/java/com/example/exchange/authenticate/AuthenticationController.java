package com.example.exchange.authenticate;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exchange.user.User;
import com.example.exchange.user.UserService;

@RestController
public class AuthenticationController {
    
    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/authenticate")
    public User login(@RequestBody AuthenticationRequest request){
        User req = new User();
        req.setEmail(request.getEmail());
        req.setPassword(request.getPassword());
        req.setToken(this.authenticationService.generateJWTToken(request.getEmail(), request.getPassword()).getToken());
        //req.setUserId(((User) this.userService.getUserByEmail(request.getEmail())).getUserId());
        Optional<User> _user = this.userService.getUserByEmail(request.getEmail());
        _user.ifPresent(value -> {
            req.setUserId(value.getUserId());
            req.setAddress(value.getAddress());
            req.setUserName(value.getUserName());
        });
        return req;
    }
}
