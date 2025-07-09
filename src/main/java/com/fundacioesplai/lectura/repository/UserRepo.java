package com.fundacioesplai.lectura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundacioesplai.lectura.model.User;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
    Optional<User> findByUserId(Integer userId);
}
    