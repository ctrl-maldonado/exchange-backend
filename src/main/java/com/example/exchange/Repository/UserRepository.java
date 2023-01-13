package com.example.exchange.Repository;

import com.example.exchange.user.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String usernameFromToken);

    Optional<User> findByEmail(String email);
}
