package com.example.exchange.authenticate;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.exchange.Repository.UserRepository;

@Component
public class JwtTokenService {
    @Autowired
    UserRepository userRepository;
    private String secret;
    private Long expiration;

    public JwtTokenService(@Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") Long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    public String generateToken(String email) {
        Date createdDate = new Date();
        Date expirationDate = this.calculateExpirationDate(createdDate);
        return Jwts.builder().setClaims(new HashMap()).setSubject(email).setIssuedAt(createdDate).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, this.secret).compact();
    }

    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + this.expiration * 10000L);
    }

    public String getUsernameFromToken(String token) {
        return (String)this.getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return (Date)this.getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = this.getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return (Claims)Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenNotExpired(String token) {
        Date expiration = this.getExpirationDateFromToken(token);
        return expiration.after(new Date());
    }

    public Optional<Boolean> validateToken(String token) {
        return this.userRepository.findByUserName(this.getUsernameFromToken(token)).isPresent() && this.isTokenNotExpired(token) ? Optional.of(Boolean.TRUE) : Optional.empty();
    }
}
