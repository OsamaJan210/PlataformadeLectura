package com.fundacioesplai.lectura.repository;

import com.fundacioesplai.lectura.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
