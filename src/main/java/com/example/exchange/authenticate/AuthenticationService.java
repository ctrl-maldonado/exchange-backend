package com.example.exchange.authenticate;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.exchange.Repository.UserRepository;
import com.example.exchange.user.User;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenService jwtTokenService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthenticationService() {
    }

    public JWTTokenResponse generateJWTToken(String email, String password) {
        String token = this.jwtTokenService.generateToken(email);
        return (JWTTokenResponse)this.userRepository.findByEmail(email).filter((account) -> {
            return this.passwordEncoder.matches(password, account.getPassword());
        }).map((account) -> {
            return new JWTTokenResponse(token);
        }).orElseThrow(() -> {
            return new EntityNotFoundException("Account not found");
        });
    }
    
}
