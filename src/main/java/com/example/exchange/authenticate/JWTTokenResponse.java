package com.example.exchange.authenticate;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.exchange.Repository.UserRepository;

public class JWTTokenResponse {
    private String token;

    public JWTTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
