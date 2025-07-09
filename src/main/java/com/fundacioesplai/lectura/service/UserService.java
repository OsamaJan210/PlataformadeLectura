package com.fundacioesplai.lectura.service;

import java.util.List;

import com.fundacioesplai.lectura.dto.LoginReq;
import com.fundacioesplai.lectura.model.User;

public interface UserService {
    public User createUser(User req);

    public boolean userExsistByEmail(String email);

    public User loginUser(LoginReq req);

    public User findByUsername(String username);

    List<User> findByUsernameNot(String username);

}
